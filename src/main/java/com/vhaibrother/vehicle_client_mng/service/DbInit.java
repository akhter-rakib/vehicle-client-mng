package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.entity.Role;
import com.vhaibrother.vehicle_client_mng.entity.User;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
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
    private final PasswordEncoder passwordEncoder;

    public DbInit(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @PostConstruct
    public void addUser() {
        String roleName = "ADMIN";
        Role role = new Role();
        int roleExist = roleRepository.countByName(roleName);
        if (roleExist == 1) {
            role = roleRepository.findByName(roleName);
        } else {
            role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        }
        User user = userRepository.getByUserNameAndActiveStatusTrue(ActiveStatus.ACTIVE.getValue(), "super-admin");
        if (user == null) {
            user = new User();
            user.setUserName("super-admin");
            user.setPassword(passwordEncoder.encode("pass"));
            user.setEmail("rakibccj@gmail.com");
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
