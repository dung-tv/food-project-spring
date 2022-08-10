package com.main.food.modules.admin.service;

import com.main.food.base.BaseService;
import com.main.food.modules.admin.dto.request.AdminReqDto;
import com.main.food.modules.admin.dto.response.AdminResDto;
import com.main.food.modules.admin.entity.Admin;

public interface AdminService extends BaseService<Admin, AdminReqDto, AdminResDto, Long> {
}
