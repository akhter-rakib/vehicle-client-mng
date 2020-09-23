package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.CarCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarCompanyRepository extends JpaRepository<CarCompany, Long> {
    @Query("from CarCompany where activeStatus = (:activeStatus)")
    List<CarCompany> list(@Param("activeStatus") Integer activeStatus);

    @Query("from CarCompany where id = :carCompanyId and activeStatus = :activeStatus")
    CarCompany getByIdAndActiveStatusTrue(@Param("carCompanyId") Long carCompanyId, @Param("activeStatus") Integer activeStatus);

    CarCompany getCarCompanyByCarCompanyName(String carCompanyName);
}
