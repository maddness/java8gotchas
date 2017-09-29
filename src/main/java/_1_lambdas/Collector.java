package _1_lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * @author aostrikov
 */
public class Collector {

    /**
     * The function accepts a list of mappers and returns an operator that accepts a list of integers
     * and sequentially applies each mapper to each value (perform a transformation)
     */
    private static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper =
        functions -> ints -> {
            IntUnaryOperator operator = functions.stream().reduce(IntUnaryOperator.identity(), IntUnaryOperator::andThen);
            return ints.stream().map(operator::applyAsInt).collect(Collectors.toList());
        };

    /**
     * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
     * <p>
     * It returns a list of the same numbers.
     */
    private static final UnaryOperator<List<Integer>> identityTransformation =
        multifunctionalMapper.apply(Arrays.asList(x -> x, x -> x, x -> x));

    /**
     * The operator accepts an integer list.
     * It multiplies by two each integer number and then add one to its.
     * <p>
     * The operator returns transformed integer list.
     */
    private static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation =
        multifunctionalMapper.apply(Arrays.asList(x -> x * 2, x -> x + 1));

    /**
     * The operator accepts an integer list.
     * It squares each integer number and then get the next even number following it.
     * <p>
     * The operator returns transformed integer list.
     */
    private static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation =
        multifunctionalMapper.apply(Arrays.asList(x -> x * x, x -> x % 2 == 0 ? x + 2 : x + 1));

    public static void main(String[] args) {
        System.out.println(multTwoAndThenAddOneTransformation.apply(Arrays.asList(10, 20, 30)));
    }
}
