package umm.csci4409;

public class ThreadedMainInnerClass {

    public static final int NUM_THREADS = 20;

    public static void main(String[] args) throws InterruptedException {
        Incrementer incrementer = new Incrementer();

        IncrementAndTimer threadedIncrementer = new IncrementAndTimer(incrementer);

        threadedIncrementer.execute("Threaded Main Inner Class");
    }

    private static class Incrementer implements IncrementerIF {
        @Override
        public void doIncrements(SharedCounter counter) throws InterruptedException {
            Thread[] threads = new Thread[NUM_THREADS];

            for (int i = 0; i < NUM_THREADS; ++i) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < IncrementAndTimer.NUM_INCREMENTS / NUM_THREADS; ++j) {
                        counter.increment();
                    }
                });
            }
            for (int i = 0; i < NUM_THREADS; ++i) {
                threads[i].start();
            }
            for (int i = 0; i < NUM_THREADS; ++i) {
                threads[i].join();
            }
        }
    }
}
