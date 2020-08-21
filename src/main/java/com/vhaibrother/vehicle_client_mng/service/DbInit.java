package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.entity.Role;
import com.vhaibrother.vehicle_client_mng.entity.User;
import com.vhaibrother.vehicle_client_mng.repository.RoleRepository;
import com.vhaibrother.vehicle_client_mng.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class DbInit {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public DbInit(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;

    }

    @PostConstruct
    public void addUser() {
        Role role = new Role();
        role.setName("ADMIN");
        roleRepository.save(role);
        User user = new User();
        user.setUserName("rakib");
        user.setPassword("pass");
        user.setEmail("rakibccj@gmail.com");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);


    }
}
