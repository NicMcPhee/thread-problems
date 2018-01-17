package umm.csci4409;

public class IncrementAndTimer {
    public static final int NUM_INCREMENTS = 1000000;
    private final IncrementerIF incrementer;

    public IncrementAndTimer(IncrementerIF incrementer) {
        this.incrementer = incrementer;
    }

    public void execute() {
        SharedCounter counter = new SharedCounter();

        long start = System.currentTimeMillis();

        incrementer.doIncrements(counter);

        long end = System.currentTimeMillis();

        System.out.println("We've done " + NUM_INCREMENTS + " increments.");
        System.out.println("This took " + (end-start) + " milliseconds.");
        System.out.println("The counter is currently = " + counter.getCount());
    }
}
