package com.main.food.modules.common.mapper;

import com.main.food.base.BaseMapper;
import com.main.food.modules.common.dto.request.CategoryReqDto;
import com.main.food.modules.common.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryReqDto, Category> {
}
