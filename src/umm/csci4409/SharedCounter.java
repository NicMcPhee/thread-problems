package umm.csci4409;

public class SharedCounter {
    private int count = 0;

    public void increment() {
        ++count;
    }

    public void decrement() {
        --count;
    }

    public int getCount() {
        return count;
    }
}
