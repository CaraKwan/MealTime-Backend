package com.onlineorder.onlineorder.service;

import com.onlineorder.onlineorder.dao.CustomerDao;
import com.onlineorder.onlineorder.entity.Cart;
import com.onlineorder.onlineorder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void signUp(Customer customer) {
        //the customer object from front end contains email, firstname, lastname, password
        //have to manually set the remaining fields here
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.setEnabled(true);
        customerDao.signUp(customer);  //store in database
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}