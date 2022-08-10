package com.main.food.modules.admin.controller;

import com.main.food.base.BaseController;
import com.main.food.common.dto.ResultDto;
import com.main.food.common.enums.Permissions;
import com.main.food.modules.admin.dto.request.RoleUserReqDto;
import com.main.food.modules.admin.entity.RoleUser;
import com.main.food.modules.admin.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/admin/roles")
public class RoleController extends BaseController<RoleUser, RoleUserReqDto, RoleUser, Long> {

    @Autowired
    private RoleUserService roleUserService;

    @Override
    public RoleUserService getService() {
        return roleUserService;
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.UROLE_GET_ONE + "\")")
    public ResultDto<RoleUser> get(Long id) {
        return super.get(id);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.UROLE_GET_ALL + "\")")
    public ResultDto<List<RoleUser>> getAll() {
        return super.getAll();
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.UROLE_GET_ALL + "\")")
    public ResultDto<Page<RoleUser>> getByPage(Pageable page) {
        return super.getByPage(page);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.UROLE_CREATE + "\")")
    public ResultDto<RoleUser> save(@RequestBody @Valid RoleUserReqDto entityDto) {
        return super.save(entityDto);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.UROLE_UPDATE + "\")")
    public ResultDto<RoleUser> update(Long id, @RequestBody @Valid RoleUserReqDto entityDto) {
        return super.update(id, entityDto);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.UROLE_DELETE + "\")")
    public ResultDto<Object> delByIds(Long[] ids) {
        return super.delByIds(ids);
    }
}
