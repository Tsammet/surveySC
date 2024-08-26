package com.surveysc.surveysc.domain.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRol {

    @EmbeddedId
    private UserRolPk id;

    @ManyToOne
    @JoinColumn(name = "rol_id", insertable = false, updatable = false)
    private Rol roles;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User users;

    public UserRol() {
    }

    public UserRolPk getId() {
        return id;
    }

    public void setId(UserRolPk id) {
        this.id = id;
    }

    

}
