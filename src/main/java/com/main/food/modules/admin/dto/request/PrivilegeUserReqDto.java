package com.main.food.modules.admin.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PrivilegeUserReqDto {

    @NotNull
    private String name;

    private String description;
}