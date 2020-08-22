package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User extends BaseModel {
    @NaturalId
    private String username;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private List<Role> roles;

    @Column(nullable = false)
    private Boolean isAccountNonExpired = true;

    @Column(nullable = false)
    private Boolean isAccountNonLocked = true;

    @Column(nullable = false)
    private Boolean isCredentialsNonExpired = true;

    @Column(nullable = false)
    private Boolean isEnabled = true;

   /* @PrePersist
    public void setPreInsertData() {
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }*/
}
