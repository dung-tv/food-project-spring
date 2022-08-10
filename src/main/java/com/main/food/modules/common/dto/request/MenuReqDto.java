package com.main.food.modules.common.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class MenuReqDto {
    @NotNull
    private Double price;

    @NotNull
    private String thumbnailPic;

    @NotNull
    private String name;

    @NotNull
    private @Valid Restaurant restaurant;

    @Data
    @Schema(name = "Restaurant1")
    public static class Restaurant {
        @NotNull
        private Long id;
    }
}
