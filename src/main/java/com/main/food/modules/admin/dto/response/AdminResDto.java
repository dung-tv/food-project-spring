package com.main.food.modules.admin.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collection;

@Data
@Schema(name = "UserResDto")
public class AdminResDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean enabled;
    private boolean tokenExpired;
    private Collection<RoleUser> roles;

    @Data
    @Schema(name = "RoleUser2")
    public static class RoleUser {
        private Long id;
        private String name;
        private String description;
    }
}
