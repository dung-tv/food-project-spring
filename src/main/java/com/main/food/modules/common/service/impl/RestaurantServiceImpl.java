package com.main.food.modules.common.service.impl;

import com.main.food.modules.common.dao.RestaurantRepository;
import com.main.food.modules.common.mapper.RestaurantMapper;
import com.main.food.modules.common.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Override
    public RestaurantRepository getRepository() {
        return restaurantRepository;
    }

    @Override
    public RestaurantMapper getMapper() {
        return restaurantMapper;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
