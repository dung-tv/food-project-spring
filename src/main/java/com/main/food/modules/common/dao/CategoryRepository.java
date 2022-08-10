package com.main.food.modules.common.dao;

import com.main.food.base.BaseDao;
import com.main.food.modules.common.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseDao<Category, Long> {
}
