package com.main.food.modules.common.mapper;

import com.main.food.base.BaseMapper;
import com.main.food.modules.common.dto.request.MenuReqDto;
import com.main.food.modules.common.entity.Menu;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuMapper extends BaseMapper<Menu, MenuReqDto, Menu> {
}
