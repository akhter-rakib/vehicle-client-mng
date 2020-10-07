package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.Color;
import com.vhaibrother.vehicle_client_mng.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    int countByName(String name);

    Role findByName(String roleName);

    @Query("from Role where activeStatus = (:activeStatus)")
    List<Role> list(@Param("activeStatus") Integer activeStatus);

    @Query("from Role where id = :roleId and activeStatus = :activeStatus")
    Role getByIdAndActiveStatusTrue(@Param("roleId") Long roleId, @Param("activeStatus") Integer activeStatus);

}
