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
            SafeCopier monkey1 = new SafeCopier(introduction);
            SafeCopier monkey2 = new SafeCopier(introduction);
            SafeCopier monkey3 = new SafeCopier(introduction);
            SafeCopier monkey4 = new SafeCopier(introduction);
            SafeCopier monkey5 = new SafeCopier(introduction);
            UnsafeCopier monkey6 = new UnsafeCopier(introduction);
            UnsafeCopier monkey7 = new UnsafeCopier(introduction);
            UnsafeCopier monkey8 = new UnsafeCopier(introduction);
            UnsafeCopier monkey9 = new UnsafeCopier(introduction);
            UnsafeCopier monkey10 = new UnsafeCopier(introduction);

            monkey1.run();
            monkey2.run();
            monkey3.run();
            monkey4.run();
            monkey5.run();
            monkey6.run();
            monkey7.run();
            monkey8.run();
            monkey9.run();
            monkey10.run();




        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
    }
}