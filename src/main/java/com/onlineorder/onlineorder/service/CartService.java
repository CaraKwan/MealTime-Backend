package com.onlineorder.onlineorder.service;

import com.onlineorder.onlineorder.dao.CartDao;
import com.onlineorder.onlineorder.entity.Cart;
import com.onlineorder.onlineorder.entity.Customer;
import com.onlineorder.onlineorder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartDao cartDao;


    //Set up and return the cart object of a customer
    public Cart getCart() {
        //Get this customer object, so that we can get the cart object of this customer
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  //email
        Customer customer = customerService.getCustomer(username);

        if (customer != null) {
            Cart cart = customer.getCart();
            //Calculate the total price of the items in the OrderItem list
            double totalPrice = 0;
            for (OrderItem item : cart.getOrderItemList()) {
                totalPrice += item.getPrice() * item.getQuantity();
            }
            cart.setTotalPrice(totalPrice);
            return cart;
        }
        return new Cart();
    }

    //Remove all order items in a cart -- mimic check out
    public void cleanCart() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);
        if (customer != null) {
            cartDao.removeAllCartItems(customer.getCart());
        }
    }

}
