package com.main.food.modules.admin.dao;

import com.main.food.base.BaseDao;
import com.main.food.modules.admin.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends BaseDao<Admin, Long> {
    Admin findByEmail(String email);

    @Override
    void delete(Admin user);

}