package _1_lambdas;

/**
 * @author aostrikov
 */
public class RunnableCombiner {
    public static void main(String[] args) {
        Runnable result = andThen(
            () -> System.out.println("thread 1"),
            () -> System.out.println("thread 2")
        );

        new Thread(result).start();
    }

    private static Runnable andThen(Runnable a, Runnable b) {
        return () -> {
            System.out.println("In a thread '" + Thread.currentThread().getName() + "'");
            a.run();
            b.run();
        };
    }
}
