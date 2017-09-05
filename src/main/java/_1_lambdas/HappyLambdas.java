package _1_lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

import static java.util.Arrays.asList;

/**
 * @author aostrikov
 */
public class HappyLambdas {

    public void lambdazz() {
        BiFunction<Integer, Integer, Integer> intFunc = (a, b) -> a - b;        //referencing
        BiFunction<Integer, Integer, Integer> intFuncShort = Integer::compare;  //method reference

        Comparator<Integer> integerComparator = Integer::compare;       //another interface

        List<Integer> ints = asList(1, 5, 3, 7, 6);
        ints.sort(integerComparator);
    }

    public static void main(String[] args) {
        new HappyLambdas().havingFun(System.out::println);
    }

    private void havingFun(FuncInterface thing) {
        thing.haveFun("with me!");
    }
}
