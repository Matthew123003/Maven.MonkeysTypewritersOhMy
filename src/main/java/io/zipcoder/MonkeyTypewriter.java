package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
            UnsafeCopier unsafe1 = new UnsafeCopier(introduction);
            Thread monkey1 = new Thread(unsafe1, "monkey1");
            Thread monkey2 = new Thread(unsafe1, "monkey2");
            Thread monkey3 = new Thread(unsafe1, "monkey3");
            Thread monkey4 = new Thread(unsafe1, "monkey4");
            Thread monkey5 = new Thread(unsafe1, "monkey5");

            //These monkeys threw exceptions, saw concurrency issues
            monkey1.start();
            monkey2.start();
            monkey3.start();
            monkey4.start();
            monkey5.start();

           try {
               monkey1.join();
               monkey2.join();
               monkey3.join();
               monkey4.join();
               monkey5.join();
           }catch(InterruptedException e){
               e.printStackTrace();
               System.out.println("Unsafe Monkeys Interrupted");
           }

           SafeCopier safe1 = new SafeCopier(introduction);
           Thread monkey6 = new Thread(safe1, "monkey6");
           Thread monkey7 = new Thread(safe1, "monkey7");
           Thread monkey8 = new Thread(safe1, "monkey8");
           Thread monkey9 = new Thread(safe1, "monkey9");
           Thread monkey10 = new Thread(safe1, "monkey10");

           //These monkeys everything went great, because of the lock.
           //Allows for synchronous threads going over the same file or resource
           monkey6.start();
           monkey7.start();
           monkey8.start();
           monkey9.start();
           monkey10.start();
           try {
               monkey6.join();
               monkey7.join();
               monkey8.join();
               monkey9.join();
               monkey10.join();
           }catch(InterruptedException e){
               e.printStackTrace();
               System.out.println("Safe Monkeys Interrupted");
           }


           // This wait is here because main is still a thread and we want the main method to print the finished copies
           // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println("\nUnsafe:\n" + unsafe1.copied);
        System.out.println("\nSafe:\n" + safe1.copied);
    }
}