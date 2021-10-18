package com.onlineorder.onlineorder.controller;

import com.onlineorder.onlineorder.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ItemOrderController {

    @Autowired
    private ItemOrderService itemOrderService;

    //When an item is added to cart, save the corresponding information
    @RequestMapping(value = "/order/{menuId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addMenuItemToCart(@PathVariable int menuId) {
        itemOrderService.saveItem(menuId);
    }
}

