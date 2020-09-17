package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.LoginDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;

public interface AuthService {
    Response login(LoginDto loginDto);
}
