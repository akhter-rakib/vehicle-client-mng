package com.vhaibrother.vehicle_client_mng.repository;

import com.vhaibrother.vehicle_client_mng.entity.Color;
import com.vhaibrother.vehicle_client_mng.entity.EmailDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailDomainRepository extends JpaRepository<EmailDomain, Long> {

    @Query("from EmailDomain where activeStatus = (:activeStatus)")
    List<EmailDomain> list(@Param("activeStatus") Integer activeStatus);

    @Query("from EmailDomain where id = :domainId and activeStatus = :activeStatus")
    EmailDomain getByIdAndActiveStatusTrue(@Param("domainId") Long domainId, @Param("activeStatus") Integer activeStatus);

}
