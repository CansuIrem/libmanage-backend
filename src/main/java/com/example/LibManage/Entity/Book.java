package com.example.LibManage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    private String isbn;
    private  String author;
    private String title;
    private String category;
    private Boolean availability;
}
