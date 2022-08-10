package com.main.food.modules.common.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@NoArgsConstructor
public class RestaurantReqDto {
    @NonNull
    private String name;

    private String description;

    private String location;

    private String city;

    private String street;

    private String house;

    private String email;

    private String phone;

    private String thumbnailPic;

    private Double pricing;

    private Double samePrice;

    private boolean status;

    private Double rating;

    private boolean verified;

    @NotNull
    private Collection<RestaurantReqDto.@Valid Category> category;

    @Data
    @Schema(name = "Category1")
    public static class Category{
        @NotNull
        private Long id;
    }
}

