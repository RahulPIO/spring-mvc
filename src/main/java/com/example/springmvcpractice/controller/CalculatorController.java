package com.example.springmvcpractice.controller;

import com.example.springmvcpractice.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping
    public String sum(HttpServletRequest request, Model model) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String operation = request.getParameter("operation");
        int result = calculatorService.performOperations(number1, number2, operation);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);
        return "calculator";
    }

    @GetMapping
    public ModelAndView calculator(ModelAndView modelAndView) {
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

}
