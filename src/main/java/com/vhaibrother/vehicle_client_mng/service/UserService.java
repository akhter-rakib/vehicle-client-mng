package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User update(User user);

    User getById(Long id);

    User getByName(String name);

    String delete(Long id);

    List<User> list();
}
