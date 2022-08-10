package com.main.food.modules.common.dao;

import com.main.food.base.BaseDao;
import com.main.food.modules.common.entity.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends BaseDao<Restaurant, Long> {
}
