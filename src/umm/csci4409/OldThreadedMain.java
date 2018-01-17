package umm.csci4409;

public class OldThreadedMain {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter counter = new SharedCounter();

        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[IncrementAndTimer.NUM_INCREMENTS];
        for (int i=0; i<IncrementAndTimer.NUM_INCREMENTS; ++i) {
            threads[i] = new Thread(new Incrementer(counter));
        }
        for (int i=0; i<IncrementAndTimer.NUM_INCREMENTS; ++i) {
            threads[i].start();
        }
        for (int i=0; i<IncrementAndTimer.NUM_INCREMENTS; ++i) {
            threads[i].join();
        }

        long end = System.currentTimeMillis();

        System.out.println("We've done " + IncrementAndTimer.NUM_INCREMENTS + " increments.");
        System.out.println("This took " + (end-start) + " milliseconds.");
        System.out.println("The counter is currently = " + counter.getCount());
    }

    private static class Incrementer implements Runnable {
        private final SharedCounter counter;

        public Incrementer(SharedCounter counter) {
            this.counter = counter;
        }

        public void run() {
            counter.increment();
        }
    }
}
