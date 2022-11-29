package com.example.calculator;
import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class CalculatorParameterizedTest {
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


    public static Stream<Arguments> parametersForTests() {
        return Stream.of(Arguments.of(10, -1,1.5,0, null));
    }

}
