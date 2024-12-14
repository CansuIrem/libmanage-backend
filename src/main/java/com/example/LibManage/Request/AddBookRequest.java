package com.example.LibManage.Request;

import lombok.Data;

@Data
public class AddBookRequest {
    private  String author;
    private String title;
    private String category;
    private Boolean availability;
}
