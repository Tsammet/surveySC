package com.surveysc.surveysc.domain.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserRolPk implements Serializable {

    @Column(name = "rol_id")
    private Long rol;

    @Column(name = "user_id")
    private Long user;

    public UserRolPk() {
    }

    public Long getRol() {
        return rol;
    }

    public void setRol(Long rol) {
        this.rol = rol;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }


}
