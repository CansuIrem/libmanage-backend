package com.example.LibManage.Controller;

import com.example.LibManage.Request.AddCategoryRequest;
import com.example.LibManage.Response.GetAllCategoriesResponse;
import com.example.LibManage.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<Void> addCategory(@RequestBody AddCategoryRequest addCategoryRequest) {
        categoryService.addCategory(addCategoryRequest);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/deleteCategory/{name}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String name) {
        categoryService.deleteCategory(name);

        return ResponseEntity.ok(null);
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<GetAllCategoriesResponse> getAllCategories() {
        GetAllCategoriesResponse response = categoryService.getAllCategories();

        return ResponseEntity.ok(response);
    }
}
