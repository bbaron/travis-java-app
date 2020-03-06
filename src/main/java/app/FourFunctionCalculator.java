package app;

import java.util.Optional;

import static java.util.Optional.*;

public class FourFunctionCalculator {
    public int plus(int addend1, int addend2) {
        return addend1 + addend2;
    }

    public int times(int multiplicand, int multiplier) {
        return multiplicand * multiplier;
    }

    public int minus(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    public Optional<Integer> dividedBy(int dividend, int divisor) {
        return divisor == 0 ? empty() : of(dividend / divisor);
    }
}
