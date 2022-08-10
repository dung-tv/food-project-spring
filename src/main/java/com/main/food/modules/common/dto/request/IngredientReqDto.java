package com.main.food.modules.common.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
public class IngredientReqDto {
    @NotNull
    private String name;

    @NotNull
    private String thumbnailPic;

    @NotNull
    private Double price;

    @NotNull
    private Set<IngredientReqDto.@Valid Menu> menus;

    @Data
    @Schema(name = "Menu1")
    public static class Menu {
        @NotNull
        private Long id;
    }
}
