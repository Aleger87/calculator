package com.example.calculator.service;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String printGreeting() {
        return  "Добро пожаловать в калькулятор";
    }

    public String plus(Integer x, Integer y) {
        checkData(x, y);
        Integer z = x + y;
        return String.valueOf(x) + " + " + String.valueOf(y) + " = " + String.valueOf(z);
    }
    public String minus(Integer x, Integer y) {
        checkData(x, y);
        Integer z = x - y;
        return String.valueOf(x) + " - " + String.valueOf(y) + " = " + String.valueOf(z);
    }
    public String multiply(Integer x, Integer y) {
        checkData(x, y);
        checkNull(y);
        Integer z = x * y;
        return String.valueOf(x) + " * " + String.valueOf(y) + " = " + String.valueOf(z);
    }

    public String divide(Integer x, Integer y) {
        checkData(x, y);

        Double z = (double) x / y;
        return String.valueOf(x) + " / " + String.valueOf(y) + " = " + String.valueOf(z);
    }

    public void checkData(Integer x, Integer y) {
        if (y==0 || x == null || y == null) {
            throw new NullPointerException("Не заполнено число");
        }
    }

    public void checkNull(Integer y) {
        if (y == 0) {
            throw new IllegalArgumentException("Деление на ноль");
        }
    }



}
