package com.testing.cms.api;

import com.testing.cms.model.Customer;
import com.testing.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    //add customer
    @PostMapping
    public Customer addCustomer (@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    //list customer
    @GetMapping
    public List<Customer> getCustomer () {
        return customerService.getCustomerList();
    }

    //get customer
    @GetMapping(value = "/{customerId}")
    public Customer getCustomer (@PathVariable("customerId") int customerId) {
        return customerService.getCustomer(customerId);
    }

    //update customer
    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer (@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }

    //delete customer
    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer (@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }
}
