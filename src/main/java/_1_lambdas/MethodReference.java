package _1_lambdas;

import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author aostrikov
 */
public class MethodReference {
    public static void main(String[] args) {
        Function<Integer, Integer> func = a -> Math.abs(a);                  // Class::staticMethod
        Function<Integer, Integer> func2 = Math::abs;

        BigInteger num = new BigInteger("7");
        Function<BigInteger, BigInteger> func3 = val -> num.multiply(val);   // object::instanceMethod
        Function<BigInteger, BigInteger> func4 = num::multiply;

        BiFunction<BigInteger, BigInteger, BigInteger> func6 = (a, b) -> a.multiply(b);
        BiFunction<BigInteger, BigInteger, BigInteger> func5 = BigInteger::multiply;    // Class::instanceMethod
    }
}
