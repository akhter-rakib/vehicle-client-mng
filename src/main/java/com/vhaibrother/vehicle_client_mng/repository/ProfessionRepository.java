package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {

    @Query("from Profession where activeStatus = :activeStatus")
    List<Profession> list(@Param("activeStatus") Integer activeStatus);

    @Query("from Profession where id = :id and activeStatus = :activeStatus")
    Profession getByIdAndActiveStatusTrue(@Param("id") Long id, @Param("activeStatus") Integer activeStatus);
}
