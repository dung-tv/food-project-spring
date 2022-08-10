package com.main.food.modules.customer.controller;

import com.main.food.base.BaseController;
import com.main.food.common.dto.ResultDto;
import com.main.food.modules.customer.dto.request.CustomerReqDto;
import com.main.food.modules.customer.dto.response.CustomerResDto;
import com.main.food.modules.customer.entity.Customer;
import com.main.food.modules.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController<Customer, CustomerReqDto, CustomerResDto, Long> {
    @Autowired
    private CustomerService customerService;

    @Override
    public CustomerService getService() {
        return customerService;
    }

    @Override
    public ResultDto<CustomerResDto> get(Long id) {
        return super.get(id);
    }

    @Override
    public ResultDto<List<CustomerResDto>> getAll() {
        return super.getAll();
    }

    @Override
    public ResultDto<Page<CustomerResDto>> getByPage(Pageable page) {
        return super.getByPage(page);
    }

    @Override
    public ResultDto<CustomerResDto> save(@RequestBody @Valid CustomerReqDto entityDto) {
        return super.save(entityDto);
    }

    @Override
    public ResultDto<CustomerResDto> update(Long id, @RequestBody @Valid CustomerReqDto entityDto) {
        return super.update(id, entityDto);
    }

    @Override
    public ResultDto<CustomerResDto> saveFile(String entityDto, MultipartFile file, BindingResult error) throws BindException, IOException {
        return super.saveFile(entityDto, file, error);
    }

    @Override
    public ResultDto<CustomerResDto> updateFile(Long id, String entityDto, MultipartFile file, BindingResult error) throws BindException, IOException {
        return super.updateFile(id, entityDto, file, error);
    }

    @Override
    public ResultDto<Object> delByIds(Long[] ids) {
        return super.delByIds(ids);
    }
}
