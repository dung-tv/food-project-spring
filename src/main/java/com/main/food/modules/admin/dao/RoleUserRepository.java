package com.main.food.modules.admin.dao;

import com.main.food.base.BaseDao;
import com.main.food.modules.admin.entity.RoleUser;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepository extends BaseDao<RoleUser, Long> {

    RoleUser findByName(String name);

    @Override
    void delete(RoleUser role);

}

