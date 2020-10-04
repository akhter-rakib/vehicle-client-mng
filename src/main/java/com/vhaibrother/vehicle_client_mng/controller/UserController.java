package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.entity.Role;
import com.vhaibrother.vehicle_client_mng.entity.User;
import com.vhaibrother.vehicle_client_mng.repository.RoleRepository;
import com.vhaibrother.vehicle_client_mng.service.UserService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@ApiController
@RequestMapping(value = UrlConstraint.UserManagement.ROOT)
public class UserController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        return userService.save(user);
    }

}
