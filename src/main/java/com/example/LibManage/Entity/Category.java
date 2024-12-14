package com.example.LibManage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="category")
public class Category {
    @Id
    private String name;
}
