// package com.surveysc.surveysc.domain.entities;

// import java.util.List;
// import java.util.Collection;


// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "enabled")
//     private boolean enabled;

//     @Column(columnDefinition = "VARCHAR(12)")
//     private String username;
    
//     @Column(columnDefinition = "VARCHAR(255)")
//     private String password;

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities(){
//         List<GrantedAuthority> authorities = new ArrayList<>();
//         for (Rol role : roles){
//             authorities.add(new SimpleGrantedAuthority(role.getName()));
//         }
//         return authorities;
//     }

//     @Override
//     public String getPassword() {
//         return password;
//     }

//     @Override
//     public String getUsername() {
//         return username;
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return enabled;
//     }
// }
