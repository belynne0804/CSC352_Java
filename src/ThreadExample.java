public class ThreadExample implements Runnable {

    //private member vars
    private Thread thread;
    private String name;

    //constructor
    public ThreadExample(String name) {
        this.name = name;
        System.out.println("Created a new thread named " + name);
    }

    //start a thread
    public void initiateThread() {
        System.out.println("Initializing thread..." + getName());
        thread = new Thread(this, getName());
        thread.start();
    }

    // inherited from Runnable
    @Override
    public void run() {
        System.out.println("Running thread " + getName());
        for (int i = 0 ; i < 5; i ++) {
            System.out.println("Thread " + getName() + " counted " + i + " times");
        }

        //sleep for 1 second
        try {
            thread.sleep(1000);
        }catch (Exception e) {
            e.getMessage();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        //make 2 new ThreadExamples
        ThreadExample thread1 = new ThreadExample("Ned");
        ThreadExample thread2 = new ThreadExample("Kelly");

        //start your thread
        thread1.initiateThread();
        thread2.initiateThread();
    }
}
