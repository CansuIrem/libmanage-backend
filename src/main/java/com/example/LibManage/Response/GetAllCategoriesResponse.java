package com.example.LibManage.Response;

import com.example.LibManage.Entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class GetAllCategoriesResponse {
    List<Category> categories;
}
