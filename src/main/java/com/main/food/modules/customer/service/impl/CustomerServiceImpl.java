package com.main.food.modules.customer.service.impl;

import com.main.food.modules.customer.dao.CustomerRepository;
import com.main.food.modules.customer.entity.Customer;
import com.main.food.modules.customer.mapper.CustomerMapper;
import com.main.food.modules.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService, UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerRepository getRepository() {
        return customerRepository;
    }

    @Override
    public CustomerMapper getMapper() {
        return customerMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer userCustomer = customerRepository.findByEmail(s);
        if(userCustomer == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        List<String> privileges = new ArrayList<>();
        userCustomer.getRoles().forEach(roleAdmin -> {
            privileges.add("ROLE_" + roleAdmin.getName());
            roleAdmin.getPrivileges().forEach(privilegeAdmin -> privileges.add(privilegeAdmin.getName()));
        });
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return new org.springframework.security.core.userdetails.User(
                userCustomer.getEmail(),
                userCustomer.getPassword(),
                userCustomer.getEnabled(),
                true,
                true,
                true,
                authorities
        );
    }
}
