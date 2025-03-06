package com.example.demo.Customerlist;

import com.example.demo.Customerlist.Customer;
import com.example.demo.Customerlist.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
