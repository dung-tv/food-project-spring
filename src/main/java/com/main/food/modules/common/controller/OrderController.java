package com.main.food.modules.common.controller;

import com.main.food.base.BaseController;
import com.main.food.common.dto.ResultDto;
import com.main.food.modules.common.dto.request.OrderReqDto;
import com.main.food.modules.common.dto.response.OrderResDto;
import com.main.food.modules.common.entity.Order;
import com.main.food.modules.common.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController<Order, OrderReqDto, OrderResDto, Long> {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderService getService() {
        return orderService;
    }

    @Override
    public ResultDto<OrderResDto> get(Long id) {
        return super.get(id);
    }

    @Override
    public ResultDto<List<OrderResDto>> getAll() {
        return super.getAll();
    }

    @Override
    public ResultDto<Page<OrderResDto>> getByPage(Pageable page) {
        return super.getByPage(page);
    }

    @Override
    @Transactional
    public ResultDto<OrderResDto> save(@RequestBody @Valid OrderReqDto entityDto) {
        return super.save(entityDto);
    }

    @Override
    public ResultDto<OrderResDto> update(Long id, @RequestBody @Valid OrderReqDto entityDto) {
        return super.update(id, entityDto);
    }

    @Override
    public ResultDto<Object> delByIds(Long[] ids) {
        return super.delByIds(ids);
    }
}
