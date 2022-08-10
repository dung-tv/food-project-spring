package com.main.food.modules.admin.controller;

import com.main.food.base.BaseController;
import com.main.food.common.dto.ResultDto;
import com.main.food.common.enums.Permissions;
import com.main.food.modules.admin.dto.request.AdminReqDto;
import com.main.food.modules.admin.dto.response.AdminResDto;
import com.main.food.modules.admin.entity.Admin;
import com.main.food.modules.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/users")
public class AdminController extends BaseController<Admin, AdminReqDto, AdminResDto, Long>{

    @Autowired
    private AdminService userService;

    @Override
    public AdminService getService() {
        return userService;
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.USER_GET_ONE + "\")")
    public ResultDto<AdminResDto> get(Long id) {
        return super.get(id);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.USER_GET_ALL + "\")")
    public ResultDto<List<AdminResDto>> getAll() {
        return super.getAll();
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.USER_GET_ALL + "\")")
    public ResultDto<Page<AdminResDto>> getByPage(Pageable page) {
        return super.getByPage(page);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.USER_CREATE + "\")")
    public ResultDto<AdminResDto> save(@RequestBody @Valid AdminReqDto entityDto) {
        return super.save(entityDto);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.USER_UPDATE + "\")")
    public ResultDto<AdminResDto> update(Long id, @RequestBody @Valid AdminReqDto entityDto) {
        return super.update(id, entityDto);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.USER_DELETE + "\")")
    public ResultDto<Object> delByIds(Long[] ids) {
        return super.delByIds(ids);
    }

}
