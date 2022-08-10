package com.main.food.modules.customer.service;

import com.main.food.base.BaseService;
import com.main.food.modules.customer.dto.request.CustomerReqDto;
import com.main.food.modules.customer.dto.response.CustomerResDto;
import com.main.food.modules.customer.entity.Customer;

public interface CustomerService extends BaseService<Customer, CustomerReqDto, CustomerResDto, Long> {
}
