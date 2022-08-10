package com.main.food.modules.common.mapper;

import com.main.food.base.BaseMapper;
import com.main.food.modules.common.dto.request.OrderReqDto;
import com.main.food.modules.common.dto.response.OrderResDto;
import com.main.food.modules.common.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<Order, OrderReqDto, OrderResDto> {
}
