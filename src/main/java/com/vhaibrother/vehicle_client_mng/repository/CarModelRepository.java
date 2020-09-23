package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    @Query("from CarModel where activeStatus = (:activeStatus)")
    List<CarModel> list(@Param("activeStatus") Integer activeStatus);

    @Query("from CarModel where id = :carModelId and activeStatus = :activeStatus")
    CarModel getByIdAndActiveStatusTrue(@Param("carModelId") Long carModelId, @Param("activeStatus") Integer activeStatus);

    CarModel getCarModelsByCarModelName(String carModelName);
}
