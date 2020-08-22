package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.CarName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarNameRepository extends JpaRepository<CarName, Long> {
}
