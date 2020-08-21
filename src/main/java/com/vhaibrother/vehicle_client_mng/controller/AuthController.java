package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.LoginDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.AuthService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ApiController
@RequestMapping(UrlConstraint.AuthManagement.ROOT)
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(UrlConstraint.AuthManagement.LOGIN)
    public Response login(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) {
        return authService.login(loginDto);
    }
}
