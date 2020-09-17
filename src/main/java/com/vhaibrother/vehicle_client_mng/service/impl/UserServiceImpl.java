package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.entity.User;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.UserRepository;
import com.vhaibrother.vehicle_client_mng.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getByIdAndActiveStatusTrue(ActiveStatus.ACTIVE.getValue(), id);
    }

    @Override
    public User getByName(String name) {
        return userRepository.getByUserNameAndActiveStatusTrue(ActiveStatus.ACTIVE.getValue(), name);
    }

    @Override
    public String delete(Long id) {
        User user = userRepository.getByIdAndActiveStatusTrue(ActiveStatus.ACTIVE.getValue(), id);
        user.setActiveStatus(ActiveStatus.DELETE.getValue());
        return null;
    }

    @Override
    public List<User> list() {
        return userRepository.list(ActiveStatus.ACTIVE.getValue());
    }
}
