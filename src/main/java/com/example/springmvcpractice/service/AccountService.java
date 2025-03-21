package com.example.springmvcpractice.service;

import com.example.springmvcpractice.entity.Account;
import com.example.springmvcpractice.exception.TransactionDemoException;
import com.example.springmvcpractice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void sendMoney(int receiverId, int senderId, int amount) {
        Optional<Account> optionalReceiver = accountRepository.findById(receiverId);
        Optional<Account> optionalSender = accountRepository.findById(senderId);

        if (optionalSender.isEmpty()) {
            throw new TransactionDemoException(HttpStatus.NOT_FOUND, "Sender Not Found With Given Id");
        }
        if (optionalReceiver.isEmpty()) {
            throw new TransactionDemoException(HttpStatus.NOT_FOUND, "Receiver Not Found with given id");
        }
        Account sender = optionalSender.get();
        Account receiver = optionalReceiver.get();

        if (sender.getAccountBalance() < amount) {
            throw new TransactionDemoException(HttpStatus.PAYMENT_REQUIRED, "Amount is less than bank balance");
        }

        sender.setAccountBalance(sender.getAccountBalance() - amount);
        receiver.setAccountBalance(receiver.getAccountBalance() + amount);
    }
}
