package com.example.ToDoList.Controllers;

import com.example.ToDoList.Models.Category;
import com.example.ToDoList.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @PostMapping("/")
    public void save(@RequestBody Category category){
        categoryService.saveCategory(category);
    }

    @GetMapping("")
    public List<Category> getAll(){
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) {
        categoryService.deleteCategoryById(id);
    }

}
