package com.vhaibrother.vehicle_client_mng.service.impl;


import com.vhaibrother.vehicle_client_mng.dto.UserPrinciple;
import com.vhaibrother.vehicle_client_mng.entity.User;
import com.vhaibrother.vehicle_client_mng.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getByName(userName);
        UserPrinciple userPrinciple = UserPrinciple.create(user);
        if (userPrinciple == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return userPrinciple;
    }
}
