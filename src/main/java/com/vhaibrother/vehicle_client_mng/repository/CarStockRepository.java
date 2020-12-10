package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.CarStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarStockRepository extends JpaRepository<CarStock, Long> {
    @Query("from CarStock where activeStatus = (:activeStatus)")
    List<CarStock> list(@Param("activeStatus") Integer activeStatus);

    @Query("from CarStock where id = :carStockId and activeStatus = :activeStatus")
    CarStock getByIdAndActiveStatusTrue(@Param("carStockId") Long carStockId, @Param("activeStatus") Integer activeStatus);

    @Query("from CarStock where carType = :carType and activeStatus = 1")
    List<CarStock> getByCarType(@Param("carType")  String carType);
}
