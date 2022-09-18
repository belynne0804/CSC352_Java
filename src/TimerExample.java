import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class TimerExample extends TimerTask implements Runnable
{
    public static int i = 0;
    public void run()
    {
        System.out.println("Timer ran " + i++);
    }

    public static void main(String[] args)
    {

        Timer timer = new Timer();
        TimerTask task = new TimerExample();

        /*Timer's Schedule()
            Parameters:
            task - task to be scheduled.
            delay - delay in milliseconds before task is to be executed.
        Throws:*/
        timer.schedule(task, 2000, 5000);
    }

    //Fixed-rate execution Timer
    static class SafeTest
    {
        protected static SafeTest test;
        public static void main(String[] args) throws InterruptedException
        {
            test = new SafeTest();

            //creating a new instance of timer class
            Timer timer = new Timer();
            TimerTask task = new SafeTimer();

            //instance of date object for fixed-rate execution
            Date date = new Date();

            //Schedules the specified task for repeated fixed-rate execution,
            // beginning after the specified delaySyntax period
            timer.scheduleAtFixedRate(task, date, 5000);

            System.out.println("Timer running");
            synchronized(test)
            {
                //make the main thread wait
                test.wait();

                //once our timer has scheduled the task 4 times,
                //the main thread resumes and terminates the timer
                timer.cancel();

                //purge is used to remove all canceled
                //tasks from the timer's stack queue
                System.out.println(timer.purge());
            }
        }
    }

    static class SafeTimer extends TimerTask
    {
        public static int i = 0;
        public void run()
        {
            System.out.println("Timer ran " + ++i);
            if(i == 4)
            {
                synchronized(SafeTest.test)
                {
                    //notify 'wakes up' a single thread
                    SafeTest.test.notify();
                }
            }
        }
    }
}

