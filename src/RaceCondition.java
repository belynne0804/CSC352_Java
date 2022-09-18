import java.util.stream.IntStream;

public class RaceCondition {

    static class DangerCounter {
        private int counter;

        // PROBLEM... increment is NOT an atomic operation.
        public int getAndIncrementCounter() {
            return counter++;
        }

        public int get() {
            return this.counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }

    static class GoodCounter {
        private int counter;

        // SAFE with 'synchronized'
        public synchronized int getAndIncrementCounter() {
            return counter++;
        }

        public int get() {
            return this.counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //make some new Danger Threads
        DangerCounter dangerCounter = new DangerCounter();

        dangerCounter.setCounter(0);
        Thread thread1 = new Thread(() -> IntStream.range(0, 10)
                .forEach(i -> dangerCounter.getAndIncrementCounter()));
        Thread thread2 = new Thread(() -> IntStream.range(0, 10)
                .forEach(i -> dangerCounter.getAndIncrementCounter()));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // Each thread increment 10 times, so I expected 20 as result...[not] Surprise!!!
        // In each run it gives different results.
        System.out.println("Count: " + dangerCounter.get());

        //make some new Safe Threads
        GoodCounter goodCounter = new GoodCounter();

        goodCounter.setCounter(0);
        Thread safe1 = new Thread(() -> IntStream.range(0, 10)
                .forEach(i -> goodCounter.getAndIncrementCounter()));
        Thread safe2 = new Thread(() -> IntStream.range(0, 10)
                .forEach(i -> goodCounter.getAndIncrementCounter()));

        safe1.start();
        safe2.start();

        safe1.join();
        safe2.join();

        System.out.println("Safe thread count: " + goodCounter.get());
    }
}
