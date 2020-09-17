package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("from Client where activeStatus = :activeStatus")
    List<Client> list(@Param("activeStatus") Integer activeStatus);

    @Query("from Client where id = :id and activeStatus = :activeStatus")
    Client getByIdAndActiveStatusTrue(@Param("id") Long id, @Param("activeStatus") Integer activeStatus);
}
