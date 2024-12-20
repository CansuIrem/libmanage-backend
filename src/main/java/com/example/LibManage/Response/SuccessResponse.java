package com.example.LibManage.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse <T>{
    private boolean success;
    private String message;
    private T data;
}
