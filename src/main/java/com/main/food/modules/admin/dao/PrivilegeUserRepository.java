package com.main.food.modules.admin.dao;

import com.main.food.base.BaseDao;
import com.main.food.modules.admin.entity.PrivilegeUser;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeUserRepository extends BaseDao<PrivilegeUser, Long> {

    PrivilegeUser findByName(String name);

    @Override
    void delete(PrivilegeUser privilege);

}