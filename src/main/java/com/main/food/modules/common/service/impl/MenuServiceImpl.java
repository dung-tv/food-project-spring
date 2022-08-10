package com.main.food.modules.common.service.impl;

import com.main.food.modules.common.dao.MenuRepository;
import com.main.food.modules.common.mapper.MenuMapper;
import com.main.food.modules.common.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public MenuRepository getRepository() {
        return menuRepository;
    }

    @Override
    public MenuMapper getMapper() {
        return menuMapper;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
