//package com.main.dat_do_an.common.validator.event;
//
//import com.main.dat_do_an.modules.admin.dao.NodeRepository;
//import com.main.dat_do_an.modules.admin.dao.PrivilegeAdminRepository;
//import com.main.dat_do_an.modules.admin.dao.RoleAdminRepository;
//import com.main.dat_do_an.modules.admin.dao.UserAdminRepository;
//import com.main.dat_do_an.modules.admin.entity.Node;
//import com.main.dat_do_an.modules.admin.entity.Privilege;
//import com.main.dat_do_an.modules.admin.entity.Role;
//import com.main.dat_do_an.modules.admin.entity.UserAdmin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//@Component
//public class SetupDataLoader implements
//        ApplicationListener<ContextRefreshedEvent> {
//
//    boolean alreadySetup = false;
//
//    @Autowired
//    private UserAdminRepository userRepository;
//
//    @Autowired
//    private RoleAdminRepository roleRepository;
//
//    @Autowired
//    private PrivilegeAdminRepository privilegeRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        if (alreadySetup)
//            return;
//        Privilege readPrivilege
//                = createPrivilegeIfNotFound("READ_PRIVILEGE");
//        Privilege writePrivilege
//                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
//
//        List<Privilege> adminPrivileges = Arrays.asList(
//                readPrivilege, writePrivilege);
//        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
//        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
//
//        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
//        UserAdmin user = new UserAdmin();
//        user.setFirstName("Test");
//        user.setLastName("Test");
//        user.setPassword(passwordEncoder.encode("test"));
//        user.setEmail("test@test.com");
//        user.setRoles(Arrays.asList(adminRole));
//        user.setEnabled(true);
//        userRepository.save(user);
//
//
//        nodeEvent();
//
//        alreadySetup = true;
//    }
//
//    @Transactional
//    Privilege createPrivilegeIfNotFound(String name) {
//
//        Privilege privilege = privilegeRepository.findByName(name);
//        if (privilege == null) {
//            privilege = new Privilege(name);
//            privilegeRepository.save(privilege);
//        }
//        return privilege;
//    }
//
//    @Transactional
//    Role createRoleIfNotFound(
//            String name, Collection<Privilege> privileges) {
//
//        Role role = roleRepository.findByName(name);
//        if (role == null) {
//            role = new Role(name);
//            role.setPrivileges(privileges);
//            roleRepository.save(role);
//        }
//        return role;
//    }
//
//    @Autowired
//    private NodeRepository repository;
//
//    public void nodeEvent() {
//        Node root = new Node();
//        root.setName("Store");
//        root.setParentNode(null);
//        repository.save(root);
//
//        // Populate Books Node (along with children)
//        Node books = new Node();
//        books.setName("Books");
//        books.setParentNode(root);
//        repository.save(books);
//
//        Node horror = new Node();
//        horror.setName("Horror");
//        horror.setParentNode(books);
//        repository.save(horror);
//
//        Node romance = new Node();
//        romance.setName("Romance");
//        romance.setParentNode(books);
//        repository.save(romance);
//
//        Node fantasy = new Node();
//        fantasy.setName("Fantasy");
//        fantasy.setParentNode(books);
//        repository.save(fantasy);
//
//        // Populate Coffee Node (along with children)
//        Node coffee = new Node();
//        coffee.setName("Coffee");
//        coffee.setParentNode(root);
//        repository.save(coffee);
//
//        Node mocha = new Node();
//        mocha.setName("Mocha");
//        mocha.setParentNode(coffee);
//        repository.save(mocha);
//
//        Node latte = new Node();
//        latte.setName("Latte");
//        latte.setParentNode(coffee);
//        repository.save(latte);
//
//        // Populate show espresso as a child underneath the Latte node.
//        Node espresso = new Node();
//        espresso.setName("Espresso");
//        espresso.setParentNode(latte);
//        repository.save(espresso);
//    }
//}