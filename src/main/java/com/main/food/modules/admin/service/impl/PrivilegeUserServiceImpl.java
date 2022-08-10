package com.main.food.modules.admin.service.impl;

import com.main.food.modules.admin.dao.PrivilegeUserRepository;
import com.main.food.modules.admin.mapper.PrivilegeUserMapper;
import com.main.food.modules.admin.service.PrivilegeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "privilegeService")
public class PrivilegeUserServiceImpl implements PrivilegeUserService {
    @Autowired
    private PrivilegeUserRepository privilegeUserRepository;

    @Autowired
    private PrivilegeUserMapper privilegeUserMapper;

    @Override
    public PrivilegeUserRepository getRepository() {
        return privilegeUserRepository;
    }

    @Override
    public PrivilegeUserMapper getMapper() {
        return privilegeUserMapper;
    }
}
