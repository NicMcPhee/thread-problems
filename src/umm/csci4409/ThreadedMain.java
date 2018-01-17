package umm.csci4409;

public class ThreadedMain {
    public static void main(String[] args) throws InterruptedException {
        IncrementAndTimer threadedIncrementer
                = new IncrementAndTimer(
                (SharedCounter counter) -> {
                    Thread[] threads = new Thread[IncrementAndTimer.NUM_INCREMENTS];
                    for (int i=0; i<IncrementAndTimer.NUM_INCREMENTS; ++i) {
                        threads[i] = new Thread(counter::increment);
                    }
                    for (int i=0; i<IncrementAndTimer.NUM_INCREMENTS; ++i) {
                        threads[i].start();
                    }
                    for (int i=0; i<IncrementAndTimer.NUM_INCREMENTS; ++i) {
                        threads[i].join();
                    }
                });
        threadedIncrementer.execute();
    }
}
