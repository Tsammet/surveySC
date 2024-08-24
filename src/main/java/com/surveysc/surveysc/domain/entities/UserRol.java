package com.surveysc.surveysc.domain.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRol {

    @EmbeddedId
    private UserRolPk id;

    public UserRol() {
    }

    public UserRolPk getId() {
        return id;
    }

    public void setId(UserRolPk id) {
        this.id = id;
    }

    

}
