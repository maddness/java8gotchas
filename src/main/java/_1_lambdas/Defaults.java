package _1_lambdas;

import java.util.function.IntPredicate;

/**
 * @author aostrikov
 */
interface First {
    default int doWork() {
        return 5;
    }
}

class Second {
    public int doWork() {
        return 2;
    }
}

//interfaces clash
public class Defaults extends Second implements First{
    public static void main(String[] args) {
        System.out.println((new Defaults().doWork()));
    }

}
