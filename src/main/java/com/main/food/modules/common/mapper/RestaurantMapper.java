package com.main.food.modules.common.mapper;

import com.main.food.base.BaseMapper;
import com.main.food.modules.common.dto.request.RestaurantReqDto;
import com.main.food.modules.common.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends BaseMapper<Restaurant, RestaurantReqDto, Restaurant> {
}
