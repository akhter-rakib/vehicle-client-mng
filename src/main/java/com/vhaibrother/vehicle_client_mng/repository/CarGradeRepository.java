package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.CarGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarGradeRepository extends JpaRepository<CarGrade, Long> {

    @Query("from CarGrade where activeStatus = (:activeStatus)")
    List<CarGrade> list(@Param("activeStatus") Integer activeStatus);

    @Query("from CarGrade where id = :carGradeId and activeStatus = :activeStatus")
    CarGrade getByIdAndActiveStatusTrue(@Param("carGradeId") Long carGradeId, @Param("activeStatus") Integer activeStatus);

    CarGrade getCarGradeByGradeName(String carGradeName);
}
