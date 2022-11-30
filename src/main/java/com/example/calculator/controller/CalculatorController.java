package com.example.calculator.controller;
import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
   private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String printGreeting() {
       return this.calculatorService.printGreeting();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") Integer x, @RequestParam("num2") Integer y) {
        return this.calculatorService.plus(x, y);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") Integer x, @RequestParam("num2") Integer y) {
        return this.calculatorService.minus(x, y);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") Integer x, @RequestParam("num2") Integer y) {
        return this.calculatorService.multiply(x, y);
    }
   @GetMapping("/divide")
   public String divide(@RequestParam("num1") Integer x, @RequestParam("num2") Integer y) {
       return this.calculatorService.divide(x, y);
   }

}
