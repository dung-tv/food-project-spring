package com.main.food.modules.admin.dto.request;

import com.main.food.common.validator.PasswordMatches;
import com.main.food.common.validator.ValidEmail;
import com.main.food.common.validator.ValidPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@PasswordMatches
@Data
public class AdminReqDto {

    @NotNull
    @Size(min = 1, message = "{Size.userDto.firstName}")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "{Size.userDto.lastName}")
    private String lastName;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    private String phone;

    @NotNull
    private Set<AdminReqDto.@Valid RoleAdmin> roles;

    @Data
    @Schema(name = "RoleAdmin1")
    public static class RoleAdmin{

        @NotNull
        private Long id;
    }
}
