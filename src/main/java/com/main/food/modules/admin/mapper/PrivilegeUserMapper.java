package com.main.food.modules.admin.mapper;

import com.main.food.base.BaseMapper;
import com.main.food.modules.admin.dto.request.PrivilegeUserReqDto;
import com.main.food.modules.admin.entity.PrivilegeUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrivilegeUserMapper extends BaseMapper<PrivilegeUser, PrivilegeUserReqDto, PrivilegeUser> {
}
