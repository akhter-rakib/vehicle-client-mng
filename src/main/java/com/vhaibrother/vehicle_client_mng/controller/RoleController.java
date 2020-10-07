package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.dto.RoleDto;
import com.vhaibrother.vehicle_client_mng.service.RoleService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@ApiController
@RequestMapping(UrlConstraint.RoleManagement.ROOT)
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Response saveRole(@RequestBody RoleDto roleDto) {
        return roleService.save(roleDto);
    }

    @GetMapping
    public Response getAll() {
        return roleService.getAll();
    }

    @GetMapping(value = UrlConstraint.RoleManagement.GET)
    public Response getById(@PathVariable("roleId") Long roleId) {
        return roleService.getById(roleId);
    }

    @DeleteMapping(value = UrlConstraint.RoleManagement.DELETE)
    public Response delRole(@PathVariable("roleId") Long roleId) {
        return roleService.del(roleId);
    }

    @PutMapping(value = UrlConstraint.RoleManagement.PUT)
    public Response updateRole(@RequestBody RoleDto roleDto, @PathVariable("roleId") Long roleId) {
        return roleService.update(roleId, roleDto);
    }
}
