package com.example.LibManage.Service;

import com.example.LibManage.Entity.Category;
import com.example.LibManage.Error.CategoryAlreadyExists;
import com.example.LibManage.Error.CategoryNotFoundException;
import com.example.LibManage.Repository.CategoryRepository;
import com.example.LibManage.Request.AddCategoryRequest;
import com.example.LibManage.Response.GetAllCategoriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public boolean isCategoryExist(String name) {
        return  categoryRepository.findByName(name).isPresent();
    }

    public void addCategory(AddCategoryRequest addCategoryRequest) {
        String categoryName = addCategoryRequest.getName().toUpperCase();
        if (isCategoryExist(categoryName)) {
            throw new CategoryAlreadyExists();
        }

        Category category = new Category();
        category.setName(categoryName);

        categoryRepository.save(category);
    }

    public void deleteCategory(String name) {
        String categoryName = name.toUpperCase();

        Category category = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new CategoryNotFoundException());

        categoryRepository.delete(category);
    }

    public GetAllCategoriesResponse getAllCategories() {
        GetAllCategoriesResponse response = new GetAllCategoriesResponse();
        List<Category> categories = categoryRepository.findAll();

        response.setCategories(categories);
        return response;
    }
}
