package com.main.food.modules.common.mapper;

import com.main.food.base.BaseMapper;
import com.main.food.modules.common.dto.request.IngredientReqDto;
import com.main.food.modules.common.entity.Ingredient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper extends BaseMapper<Ingredient, IngredientReqDto, Ingredient> {
}
