package umm.csci4409;

/*
 * If we run this with fib turned on in SharedCounter, everything seems
 * good (and it definitely goes faster), but if we turn fib off we see
 * that there are problems.
 */
public class ThreadedMainLambda {
    public static void main(String[] args) throws InterruptedException {
        final int numThreads = 20;
        IncrementAndTimer threadedIncrementer
                = new IncrementAndTimer(
                (SharedCounter counter) -> {
                    Thread[] threads = new Thread[numThreads];
                    for (int i = 0; i < numThreads; ++i) {
                        threads[i] = new Thread(() -> {
                            for (int j = 0; j < IncrementAndTimer.NUM_INCREMENTS / numThreads; ++j) {
                                counter.increment();
                            }
                        });
                    }
                    for (int i = 0; i < numThreads; ++i) {
                        threads[i].start();
                    }
                    for (int i = 0; i < numThreads; ++i) {
                        threads[i].join();
                    }
                });
        threadedIncrementer.execute("Threaded Main Lambda");
    }
}
