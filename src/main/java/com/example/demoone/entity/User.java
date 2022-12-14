package com.example.demoone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = -1)
    private String username;

    @Column(name = "password", nullable = false, length = -1)
    private String password;

    @Column(name = "email", nullable = false, length = -1)
    private String email;

    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "active", nullable = false)
    private boolean active;

    @JsonIgnore
    @OneToMany (mappedBy = "user")
    private List<Post> posts;

    @PrePersist
    public void prePersist(){
        createDate = LocalDateTime.now();
        active = true;
    }
}
