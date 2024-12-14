package com.example.LibManage.Error;

public class CategoryAlreadyExists extends RuntimeException{
    public CategoryAlreadyExists() {
        super("Kategori zaten mevcut");
    }
}
