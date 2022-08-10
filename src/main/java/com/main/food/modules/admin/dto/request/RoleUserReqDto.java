package com.main.food.modules.admin.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class RoleUserReqDto {

    @NotNull
    @Size(min = 1, message = "{Size.roleDto.name}")
    private String name;

    private String description;

    @NotNull
    private Set<RoleUserReqDto.@Valid PrivilegeAdmin> privileges;

    @Data
    @Schema(name = "PrivilegeAdmin1")
    public static class PrivilegeAdmin{

        @NotNull
        private Long id;
    }
}
