package com.example.springmvcpractice.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int performOperations(String number1, String number2, String operation) {
        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Enter Valid Operation");
        }
        return result;
    }
}
