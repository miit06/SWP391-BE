package com.example.demo.Customerlist;

import com.example.demo.Customerlist.Customer;
import com.example.demo.Customerlist.UpdateHistory;
import com.example.demo.Customerlist.CustomerService;
import com.example.demo.Customerlist.UpdateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private UpdateHistoryService updateHistoryService;

    // List all customers
    @GetMapping
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    // View customer details
    @GetMapping("/{id}")
    public String viewCustomerDetails(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        List<UpdateHistory> updateHistory = updateHistoryService.getHistoryByCustomerId(id);

        model.addAttribute("customer", customer);
        model.addAttribute("updateHistory", updateHistory);
        return "customer-details";
    }

    // Save or update a customer
    @PostMapping
    public String saveCustomer(@ModelAttribute Customer customer) {
        customer.setUpdatedAt(LocalDateTime.now());

        // Save the new customer or update the existing one
        customerService.saveCustomer(customer);

        // Log the update history
        UpdateHistory history = new UpdateHistory();
        history.setCustomer(customer);
        history.setFullName(customer.getFullName());
        history.setEmail(customer.getEmail());
        history.setGender(customer.getGender());
        history.setMobile(customer.getMobile());
        history.setStatus(customer.getStatus());
        history.setUpdatedAt(LocalDateTime.now());
        updateHistoryService.saveUpdateHistory(history);

        return "redirect:/customers";
    }
}
