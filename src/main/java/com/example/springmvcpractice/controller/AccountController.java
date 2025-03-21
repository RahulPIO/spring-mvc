package com.example.springmvcpractice.controller;

import com.example.springmvcpractice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/send-money")
    public ResponseEntity<String> sendMoney(@RequestParam("senderId") int senderId, @RequestParam("receiverId") int receiverId, int amount) {
        accountService.sendMoney(receiverId, senderId, amount);
        return ResponseEntity.ok("Transaction SuccessFull");
    }


}
