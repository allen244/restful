package com.avs.controllers.v1;

import com.avs.api.v1.model.CategoryDTO;
import com.avs.api.v1.model.CatorgoryListDTO;
import com.avs.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/categories/")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CatorgoryListDTO getallCatetories(){
        return new CatorgoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }


}
