package com.example.calculator;
import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private static final Integer NUM_1 = 10;
    private static final Integer NUM_2 = 3;
    private final CalculatorService calculatorService = new CalculatorService();


    @Test
    public void plus() {
        String result = calculatorService.plus(NUM_1, NUM_2);
        Integer numResult = NUM_1 + NUM_2;
        String standard = String.valueOf(NUM_1) + " + " + String.valueOf(NUM_2) + " = " + String.valueOf(numResult);
        assertEquals(standard, result);
    }
    @Test
    public void minus() {
        String result = calculatorService.minus(NUM_1, NUM_2);
        Integer numResult = NUM_1 - NUM_2;
        String standard = String.valueOf(NUM_1) + " - " + String.valueOf(NUM_2) + " = " + String.valueOf(numResult);
        assertEquals(standard, result);
    }
    @Test
    public void multiply() {
        String result = calculatorService.multiply(NUM_1, NUM_2);
        Integer numResult = NUM_1 * NUM_2;
        String standard = String.valueOf(NUM_1) + " * " + String.valueOf(NUM_2) + " = " + String.valueOf(numResult);
        assertEquals(standard, result);
    }
    @Test
    public void divide() {
        String result = calculatorService.divide(NUM_1, NUM_2);
        Double numResult = (double) NUM_1 / NUM_2;
        String standard = String.valueOf(NUM_1) + " / " + String.valueOf(NUM_2) + " = " + String.valueOf(numResult);
        assertEquals(standard, result);
    }

}
