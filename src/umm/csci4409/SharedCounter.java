package umm.csci4409;

public class SharedCounter {
    private static final boolean RUN_FIB = false;
    private int count = 0;

    public int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    public synchronized void increment() {
        if (RUN_FIB && fib(30) < 0) {
            ++count;
        } else {
            ++count;
        }
    }

    public void decrement() {
        --count;
    }

    public int getCount() {
        return count;
    }
}
