package com.example.LibManage.Request;

import lombok.Data;

@Data
public class UpdateBookRequest {
    private String isbn;
    private String author;
    private String title;
    private String category;
    private Boolean availability;
}
