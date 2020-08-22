package com.vhaibrother.vehicle_client_mng.service.impl;


import com.vhaibrother.vehicle_client_mng.entity.MyUserDetails;
import com.vhaibrother.vehicle_client_mng.entity.User;
import com.vhaibrother.vehicle_client_mng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        //   MyUserDetails userPrinciple = MyUserDetails.create(user);
      /*  if (userPrinciple == null) {
            throw new UsernameNotFoundException("User Not Found");
        }*/
        return new MyUserDetails(user);
    }
}
