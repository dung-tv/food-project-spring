package com.main.food.modules.admin.service.impl;

import com.main.food.modules.admin.dao.AdminRepository;
import com.main.food.modules.admin.entity.Admin;
import com.main.food.modules.admin.entity.PrivilegeUser;
import com.main.food.modules.admin.entity.RoleUser;
import com.main.food.modules.admin.mapper.AdminMapper;
import com.main.food.modules.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service(value = "userAdminService")
public class AdminServiceImpl implements UserDetailsService, AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    //    @Override
//    public UserAdmin save(UserAdminDto userAdminDto) {
//        if (emailExists(userAdminDto.getEmail())) {
//            throw new UserAlreadyExistException("There is an account with that email address: " + userAdminDto.getEmail());
//        }
//        final UserAdmin user = new UserAdmin();
//
//        user.setFirstName(userAdminDto.getFirstName());
//        user.setLastName(userAdminDto.getLastName());
//        user.setPassword(passwordEncoder.encode(userAdminDto.getPassword()));
//        user.setEmail(userAdminDto.getEmail());
//        user.setPhone(userAdminDto.getPhone());
//        user.setEnabled(true);
//        user.setRoles(Arrays.asList(roleAdminRepository.findByName("USER")));
//        return getRepository().save(user);
//    }

    private boolean emailExists(final String email) {
        return adminRepository.findByEmail(email) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(s);
        if(admin == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(
                admin.getEmail(),
                admin.getPassword(),
                admin.getEnabled(),
                true,
                true,
                true,
                getAuthorities(admin.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<RoleUser> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<RoleUser> roles) {

        List<String> privileges = new ArrayList<>();
        List<PrivilegeUser> collection = new ArrayList<>();
        for (RoleUser role : roles) {
            privileges.add("ROLE_" + role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (PrivilegeUser item : collection) {
            privileges.add(item.getName());
        }

        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    @Override
    public AdminRepository getRepository() {
        return adminRepository;
    }

    @Override
    public AdminMapper getMapper() {
        return adminMapper;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
