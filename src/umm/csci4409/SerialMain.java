package umm.csci4409;

public class SerialMain {
    public static void main(String[] args) {
        IncrementAndTimer serialIncrementer
                = new IncrementAndTimer(
                (SharedCounter counter) -> {
                    for (int i = 0; i < IncrementAndTimer.NUM_INCREMENTS; ++i) {
                        counter.increment();
                    }
                });
        serialIncrementer.execute();
    }
}
