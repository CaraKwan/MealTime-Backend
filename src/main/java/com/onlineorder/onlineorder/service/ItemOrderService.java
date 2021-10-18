package com.onlineorder.onlineorder.service;

import com.onlineorder.onlineorder.dao.ItemOrderDao;
import com.onlineorder.onlineorder.entity.Customer;
import com.onlineorder.onlineorder.entity.MenuItem;
import com.onlineorder.onlineorder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderService {

    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemOrderDao itemOrderDao;

    //For an order added to cart, set up the OrderItem information and save it
    public void saveItem(int menuId) {
        final OrderItem orderItem = new OrderItem();
        final MenuItem menuItem = menuInfoService.getMenuItem(menuId);

        //Get this customer object, so that we can get the cart object of this customer
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  //email
        Customer customer = customerService.getCustomer(username);

        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());
        itemOrderDao.save(orderItem);
    }
}
