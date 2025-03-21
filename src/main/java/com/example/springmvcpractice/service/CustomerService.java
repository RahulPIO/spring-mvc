package com.example.springmvcpractice.service;

import com.example.springmvcpractice.entity.Customer;
import com.example.springmvcpractice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(long id) {
        Customer customer = null;
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        } else {
            throw new NoSuchElementException("Customer not found with given id");
        }
        return customer;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
