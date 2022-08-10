package com.main.food.modules.common.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@NoArgsConstructor
public class OrderReqDto {
    private String name;

    private String location;

    private String city;

    private String street;

    private String house;

    private Double totalPrice;

    private Collection<Menu> menus;

    private Collection<Ingredient> ingredients;

    private Restaurant restaurant;

    private Customer customer;

    @Data
    @Schema(name = "Menu2")
    public static class Menu {
        @NotNull
        private Long id;
    }

    @Data
    @Schema(name = "Ingredient1")
    public static class Ingredient {
        @NotNull
        private Long id;
    }

    @Data
    @Schema(name = "Restaurant1")
    public static class Restaurant {
        @NotNull
        private Long id;
    }

    @Data
    @Schema(name = "Customer1")
    public static class Customer {
        @NotNull
        private Long id;
    }
}
