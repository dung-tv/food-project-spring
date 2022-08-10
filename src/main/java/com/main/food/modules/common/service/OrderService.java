package com.main.food.modules.common.service;

import com.main.food.base.BaseService;
import com.main.food.modules.common.dto.request.OrderReqDto;
import com.main.food.modules.common.dto.response.OrderResDto;
import com.main.food.modules.common.entity.Order;

public interface OrderService extends BaseService<Order, OrderReqDto, OrderResDto, Long> {
}
