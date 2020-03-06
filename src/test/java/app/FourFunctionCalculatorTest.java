package app;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.*;


class FourFunctionCalculatorTest {
    private final FourFunctionCalculator ffc = new FourFunctionCalculator();
    private final Random random = new Random();
    private final int plusUnit = 0;
    private final int timesUnit = 1;

    @Test
    void unit() {
        int n = random.nextInt(100) + 1;
        assertAll("unit function",
                () -> assertEquals(n, ffc.plus(n, plusUnit), () -> describe(n, "+", plusUnit, n)),
                () -> assertEquals(n, ffc.minus(n, plusUnit), () -> describe(n, "-", plusUnit, n)),
                () -> assertEquals(n, ffc.times(n, timesUnit), () -> describe(n, "*", timesUnit, n)),
                () -> assertEquals(n, ffc.dividedBy(n, timesUnit).orElseThrow(), () -> describe(n, "/", timesUnit, n)),
                () -> {
                    Optional<Integer> result = ffc.dividedBy(n, timesUnit);
                    assertAll("division",
                            () -> assertTrue(result.isPresent(), "quotient should exist"),
                            () -> assertEquals(n, result.orElseThrow(), () -> describe(n, "/", timesUnit, n)),
                            () -> assertTrue(ffc.dividedBy(n, 0).isEmpty(), () -> n + " / 0 does not exist"));
                }
        );
    }

    private String describe(Number a, String op, Number b, Number expected) {
        return String.format("%s %s %s == %s", a, op, b, expected);
    }
}

