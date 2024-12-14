package com.example.LibManage.Error;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super("Kitap mevcut değil");
    }
}
