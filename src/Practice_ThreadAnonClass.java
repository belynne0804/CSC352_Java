// Java program to illustrate defining a thread
// Using Anonymous Inner class that implements an interface

// Main class
public class Practice_ThreadAnonClass {

    // Main driver method
    public static void main(String[] args)
    {
        // Here we are using Anonymous Inner class
        // that implements a interface i.e. Runnable
        Runnable r = new Runnable() {
            // run() method for the thread
            public void run()
            {
                // Print statement when run() is invoked
                System.out.println("Child Thread");
            }
        };

        // Creating thread in main() using Thread class
        Thread t = new Thread(r);

        // Starting the thread using start() method
        // which invokes run() method automatically
        t.start();

        // Print statement only
        System.out.println("Main Thread");
    }
}