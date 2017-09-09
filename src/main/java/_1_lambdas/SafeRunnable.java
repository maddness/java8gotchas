package _1_lambdas;

import java.util.concurrent.TimeUnit;

/**
 * @author aostrikov
 */
public class SafeRunnable {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " in main!");

        new Thread(() -> System.out.println(Thread.currentThread().getName() + " hi")).start();

        new Thread(uncheck(() -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + " and hello!");
        })).start();

    }

    private static Runnable uncheck(UncheckedRunnable myRunnable) {
        return () -> {
            try {
                myRunnable.runUnchecked();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

}

@FunctionalInterface
interface UncheckedRunnable {
    void runUnchecked() throws Exception;
}
