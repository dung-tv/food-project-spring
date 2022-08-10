package com.main.food.modules.common.dao;

import com.main.food.base.BaseDao;
import com.main.food.modules.common.entity.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends BaseDao<Ingredient, Long> {
}
