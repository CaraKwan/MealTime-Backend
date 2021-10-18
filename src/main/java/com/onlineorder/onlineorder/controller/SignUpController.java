package com.onlineorder.onlineorder.controller;

import com.onlineorder.onlineorder.entity.Customer;
import com.onlineorder.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpController {

    @Autowired
    private CustomerService customerService;

    //Define REST API
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody Customer customer) {  //convert JSON object to Customer object
        customerService.signUp(customer);
    }
}
