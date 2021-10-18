package com.onlineorder.onlineorder.service;

import com.onlineorder.onlineorder.dao.MenuInfoDao;
import com.onlineorder.onlineorder.entity.MenuItem;
import com.onlineorder.onlineorder.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    //Return a list of restaurants
    public List<Restaurant> getRestaurants() {
        return menuInfoDao.getRestaurants();
    }

    //Return a list of all menu items of a restaurant
    public List<MenuItem> getAllMenuItem(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    //Return a menu item
    public MenuItem getMenuItem(int id) {
        return menuInfoDao.getMenuItem(id);
    }
}

