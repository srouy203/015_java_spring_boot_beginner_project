package com.testing.cms.service;

import com.testing.cms.dao.CustomerDAO;
import com.testing.cms.exception.CustomerNotFoundException;
import com.testing.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    //add customer function
    public Customer addCustomer (Customer customer) {
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;
//        return customer;
        return customerDAO.save(customer);                                   //function use with database
    }

    //list customer function
    public List<Customer> getCustomerList(){
//        return customerList;
        return customerDAO.findAll();                                       //function use with database
    }

    //find customer function
    public Customer getCustomer(int customerId){
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();

//        return customerDAO.findById(customerId).get();                        //function use with database

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available");

        return optionalCustomer.get();
    }

    //update customer function
    public Customer updateCustomer (int customerId, Customer customer){
//        customerList
//                .stream()
//                .forEach(c -> {
//                    if(c.getCustomerId() == customerId){
//                        c.setCustomerFirstName(customer.getCustomerFirstName());
//                        c.setCustomerLastName(customer.getCustomerLastName());
//                        c.setCustomerEmail(customer.getCustomerEmail());
//                    }
//                });
//
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();

        customer.setCustomerId(customerId);                                 //function use with database

        return customerDAO.save(customer);
    }

    //delete customer function
    public void deleteCustomer (int customerId) {
//            customerList
//                .stream()
//                .forEach(c-> {
//                    if (c.getCustomerId() == customerId) {
//                        customerList.remove(c);
//                    }
//                });
        customerDAO.deleteById(customerId);                                 //function use with database

    }
}
