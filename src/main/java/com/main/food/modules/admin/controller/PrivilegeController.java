package com.main.food.modules.admin.controller;

import com.main.food.base.BaseController;
import com.main.food.common.dto.ResultDto;
import com.main.food.common.enums.Permissions;
import com.main.food.modules.admin.dto.request.PrivilegeUserReqDto;
import com.main.food.modules.admin.entity.PrivilegeUser;
import com.main.food.modules.admin.service.PrivilegeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/privileges")
public class PrivilegeController extends BaseController<PrivilegeUser, PrivilegeUserReqDto, PrivilegeUser, Long> {

    @Autowired
    private PrivilegeUserService privilegeUserService;

    @Override
    public PrivilegeUserService getService() {
        return privilegeUserService;
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.PRIVILEGE_GET_ONE + "\")")
    public ResultDto<PrivilegeUser> get(Long id) {
        return super.get(id);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.PRIVILEGE_GET_ALL + "\")")
    public ResultDto<List<PrivilegeUser>> getAll() {
        return super.getAll();
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.PRIVILEGE_GET_ALL + "\")")
    public ResultDto<Page<PrivilegeUser>> getByPage(Pageable page) {
        return super.getByPage(page);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.PRIVILEGE_CREATE + "\")")
    public ResultDto<PrivilegeUser> save(@RequestBody @Valid PrivilegeUserReqDto entityDto) {
        return super.save(entityDto);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.PRIVILEGE_UPDATE + "\")")
    public ResultDto<PrivilegeUser> update(Long id, @RequestBody @Valid PrivilegeUserReqDto entityDto) {
        return super.update(id, entityDto);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.PRIVILEGE_DELETE + "\")")
    public ResultDto<Object> delByIds(Long[] ids) {
        return super.delByIds(ids);
    }
}
