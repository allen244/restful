package com.avs.api.v1.mapper;

import com.avs.api.v1.model.CategoryDTO;
import com.avs.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

@Mapping(source = "id",target="id")
    CategoryDTO categoryToCategoryDTO(Category category);
}