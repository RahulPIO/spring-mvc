package com.example.springmvcpractice.controller;

import com.example.springmvcpractice.entity.User;
import com.example.springmvcpractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user";
        } else {
            userService.saveUser(user);
            model.addAttribute("user", user);
            return "user";
        }
    }

    @GetMapping
    public String displayUser(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "user";
    }
}
