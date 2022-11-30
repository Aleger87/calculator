package com.example.calculator;
import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorParameterizedTest {
    private static final Integer NUM_1 = 10;
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("parametersForTests")
    public void plus(Integer x, Integer y) {
        Integer numResult = x + y;
        String standard = String.valueOf(x) + " + " + String.valueOf(y) + " = " + String.valueOf(numResult);
        Assertions.assertEquals( calculatorService.plus(x,y), standard);
    }

    @ParameterizedTest
    @MethodSource("parametersForTests")
    public void minus(Integer x, Integer y) {
        Integer numResult = x - y;
        String standard = String.valueOf(x) + " - " + String.valueOf(y) + " = " + String.valueOf(numResult);
        Assertions.assertEquals( calculatorService.minus(x,y), standard);
    }

    @ParameterizedTest
    @MethodSource("parametersForTests")
    public void multiply(Integer x, Integer y) {
        Integer numResult = x * y;
        String standard = String.valueOf(x) + " * " + String.valueOf(y) + " = " + String.valueOf(numResult);
        Assertions.assertEquals( calculatorService.multiply(x,y), standard);
    }

    @ParameterizedTest
    @MethodSource("parametersForTests")
    public void divide(Integer x, Integer y) {
        Double numResult =(double) x / y;
        String standard = String.valueOf(x) + " / " + String.valueOf(y) + " = " + String.valueOf(numResult);
        Assertions.assertEquals( calculatorService.divide(x,y), standard);

    }

    @ParameterizedTest
    @MethodSource("parametersForTestsNotNull")
    public void nullPointerExceptionCheckData(Integer x, Integer y) {
        Assertions.assertThrows(NullPointerException.class, () -> calculatorService.checkData(x,y), "неверное значение" );
    }

    @Test
    public void nullPointerExceptionCheck() {
        Assertions.assertThrows(NullPointerException.class, () -> calculatorService.plus(NUM_1,null));
        Assertions.assertThrows(NullPointerException.class, () -> calculatorService.minus(null, NUM_1));
        Assertions.assertThrows(NullPointerException.class, () -> calculatorService.multiply(null,null));
        Assertions.assertThrows(NullPointerException.class, () -> calculatorService.divide(NUM_1, 0));
    }



    public static Stream<Arguments> parametersForTests() {
        return Stream.of(
                Arguments.of(10, -1),
                Arguments.of(2, 1),
                Arguments.of(1, 1));
    }

    public static Stream<Arguments> parametersForTestsNotNull() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of(10, 0));
    }
}
