package com.example.LibManage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    private String username;
    private String password;
}
