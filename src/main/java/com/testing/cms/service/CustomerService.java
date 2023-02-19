package com.testing.cms.service;

import com.testing.cms.model.Customer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomerService {

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    //add customer function
    public Customer addCustomer (Customer customer) {
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerList.add(customer);
        customerIdCount++;
        return customer;
    }

    //list customer function
    public List<Customer> getCustomerList(){
        return customerList;
    }

    //find customer function
    public Customer getCustomer(int customerId){
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }

    //update customer function
    public Customer updateCustomer (int customerId, Customer customer){
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == customerId){
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });

        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }

    //delete customer function
    public void deleteCustomer (int customerId) {
        customerList
                .stream()
                .filter(c-> {
                    if(c.getCustomerId() == customerId){
                        customerList.remove(c);
                    }
                    return false;
                });
    }


}
