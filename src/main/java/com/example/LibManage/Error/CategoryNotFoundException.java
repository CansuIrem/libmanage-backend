package com.example.LibManage.Error;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
        super("Kategori bulunamadı");
    }
}
