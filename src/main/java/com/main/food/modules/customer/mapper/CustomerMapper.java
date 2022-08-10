package com.main.food.modules.customer.mapper;

import com.main.food.base.BaseMapper;
import com.main.food.modules.customer.dto.request.CustomerReqDto;
import com.main.food.modules.customer.dto.response.CustomerResDto;
import com.main.food.modules.customer.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends BaseMapper<Customer, CustomerReqDto, CustomerResDto> {
}
