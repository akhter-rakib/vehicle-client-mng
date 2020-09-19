package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long> {
    @Query("from Color where activeStatus = (:activeStatus)")
    List<Color> list(@Param("activeStatus") Integer activeStatus);

    @Query("from Color where id = :colorId and activeStatus = :activeStatus")
    Color getByIdAndActiveStatusTrue(@Param("colorId") Long colorId, @Param("activeStatus") Integer activeStatus);

    Color getColorByColorName(String colorName);
}
