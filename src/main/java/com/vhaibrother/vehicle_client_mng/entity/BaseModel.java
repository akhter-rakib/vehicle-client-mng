package com.vhaibrother.vehicle_client_mng.entity;

import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private String createdBy;
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    private Integer activeStatus;

    @PrePersist
    public void setPreInsertData() {
        this.createdAt = new Date();
        this.activeStatus = ActiveStatus.ACTIVE.getValue();
    }

    @PreUpdate
    public void setPreUpdateData() {
        this.updateAt = new Date();
        this.activeStatus = ActiveStatus.ACTIVE.getValue();
    }

}
