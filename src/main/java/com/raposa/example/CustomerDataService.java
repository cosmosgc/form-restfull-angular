package com.raposa.example;

import java.util.ArrayList;
import java.util.List;



public class CustomerDataService {
    private List<Customer> customerList = new ArrayList<>();

    private static CustomerDataService ourInstance = new CustomerDataService();

    public static CustomerDataService getInstance() {
        return ourInstance;
    }

    public String addCustomer(Customer customer) {
        String newId = Integer.toString(customerList.size() + 1);
        customer.setId(newId);
        customerList.add(customer);
        return newId;
    }
    
    
    
    public String modifyCustomer(int id, Customer customer) {
    	customer.setId(Integer.toString(id));
        customerList.set(id-1, customer);
        return Integer.toString(id-1);
    }

    public String addCustomer(int id, String name, String email, String comment, String cnpj) {
        if(id == 0)
        {
        	Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setComment(comment);
            customer.setCnpj(cnpj);
            return addCustomer(customer);
        }
        else 
        {
        	Customer customer = new Customer();
        	
            customer.setName(name);
            customer.setEmail(email);
            customer.setComment(comment);
            customer.setCnpj(cnpj);
            return modifyCustomer(id, customer);
        }
    }
    

    public List<Customer> getCustomerList() {
        return customerList;
    }
    
    

    public Customer getCustomerById(String id) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }

        return null;
    }
}