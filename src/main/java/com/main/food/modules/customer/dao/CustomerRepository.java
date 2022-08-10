package com.main.food.modules.customer.dao;

import com.main.food.base.BaseDao;
import com.main.food.modules.customer.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseDao<Customer, Long> {
    Customer findByEmail(String email);
}
