package com.main.food.modules.admin.service.impl;

import com.main.food.modules.admin.dao.RoleUserRepository;
import com.main.food.modules.admin.mapper.RoleUserMapper;
import com.main.food.modules.admin.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service(value = "roleService")
public class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    private RoleUserRepository roleUserRepository;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public RoleUserRepository getRepository() {
        return roleUserRepository;
    }

    @Override
    public RoleUserMapper getMapper() {
        return roleUserMapper;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
