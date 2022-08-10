package com.main.food.modules.admin.mapper;

import com.main.food.base.BaseMapper;
import com.main.food.modules.admin.dto.request.AdminReqDto;
import com.main.food.modules.admin.dto.response.AdminResDto;
import com.main.food.modules.admin.entity.RoleUser;
import com.main.food.modules.admin.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RoleUser.class)
public interface AdminMapper extends BaseMapper<Admin, AdminReqDto, AdminResDto> {
}
