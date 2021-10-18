package com.onlineorder.onlineorder.controller;

import com.onlineorder.onlineorder.entity.MenuItem;
import com.onlineorder.onlineorder.entity.Restaurant;
import com.onlineorder.onlineorder.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    //Return a list of restaurants and information
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody   //convert Java object to JSON
    public List<Restaurant> getRestaurants() {
        return menuInfoService.getRestaurants();
    }

    //Return a list of all menu item information of a restaurant
    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenus(@PathVariable(value = "restaurantId") int restaurantId) {
        return menuInfoService.getAllMenuItem(restaurantId);
    }
}

