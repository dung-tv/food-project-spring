package com.main.food.modules.common.dao;

import com.main.food.base.BaseDao;
import com.main.food.modules.common.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseDao<Order, Long> {
}
