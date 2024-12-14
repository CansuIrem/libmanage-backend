package com.example.LibManage.Error;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Kullanıcı adı veya parola yanlış");
    }
}
