package com.main.food.modules.common.service;

import com.main.food.base.BaseService;
import com.main.food.modules.common.dto.request.RestaurantReqDto;
import com.main.food.modules.common.entity.Restaurant;

public interface RestaurantService extends BaseService<Restaurant, RestaurantReqDto, Restaurant, Long> {
}
