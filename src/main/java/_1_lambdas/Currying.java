package _1_lambdas;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

/**
 * @author aostrikov
 */
public class Currying {
    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    private static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
        (init, reduceFunction) -> (left, right) -> {
            int result = init;
            for (int i = left; i <= right; i++) {
                result = reduceFunction.applyAsInt(result, i);
            }
            return result;
        };

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    private static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, (x, y) -> x + y);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    private static final IntBinaryOperator productOperator =
        (left, right) -> reduceIntOperator.apply(1, (x, y) -> x * y).applyAsInt(left, right);

    public static void main(String[] args) {
        System.out.println(sumOperator.applyAsInt(1, 2));
        System.out.println(productOperator.applyAsInt(7, 8));
    }
}
