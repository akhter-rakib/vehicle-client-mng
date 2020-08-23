package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class EmailDomain extends BaseModel{
    private String domainName;
}
