package com.main.food.modules.admin.mapper;

import com.main.food.base.BaseMapper;
import com.main.food.modules.admin.dto.request.RoleUserReqDto;
import com.main.food.modules.admin.entity.PrivilegeUser;
import com.main.food.modules.admin.entity.RoleUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PrivilegeUser.class)
public interface RoleUserMapper extends BaseMapper<RoleUser, RoleUserReqDto, RoleUser> {
}
