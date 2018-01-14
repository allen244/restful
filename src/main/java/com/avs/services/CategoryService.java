package com.avs.services;

import com.avs.api.v1.model.CategoryDTO;
import com.avs.domain.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);


}


