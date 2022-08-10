package com.main.food.modules.common.service.impl;

import com.main.food.modules.common.dao.IngredientRepository;
import com.main.food.modules.common.mapper.IngredientMapper;
import com.main.food.modules.common.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("ingredientService")
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientMapper ingredientMapper;

    @Override
    public IngredientRepository getRepository() {
        return ingredientRepository;
    }

    @Override
    public IngredientMapper getMapper() {
        return ingredientMapper;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
