package com.example.springmvcpractice.controller;
import com.example.springmvcpractice.entity.Customer;
import com.example.springmvcpractice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView getCustomer(ModelAndView modelAndView) {
        List<Customer> customerList = customerService.getAllCustomer();
        modelAndView.setViewName("customer");
        modelAndView.addObject(customerList);
        return modelAndView;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getCustomerId(@PathVariable long id) {
        Customer customer = null;
        try {
            customer = customerService.getCustomerById(id);
            return ResponseEntity.ok(customer);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @PostMapping
    @ResponseBody
    public Customer addCustomer(@RequestBody Customer customer) {
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Customer can't be null");
        } else {
            return customerService.createCustomer(customer);
        }
    }
}

