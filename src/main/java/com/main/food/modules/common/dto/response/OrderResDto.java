package com.main.food.modules.common.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collection;

@Data
@Schema(name = "OrderResDto")
public class OrderResDto {
    private Long id;
    private String name;
    private String location;
    private String city;
    private String street;
    private String house;
    private Double totalPrice;
    private Collection<Menu> menus;
    private Restaurant restaurant;
    private Collection<Ingredient> ingredients;

    @Data
    @Schema(name = "Menu3")
    public static class Menu {
        private Long id;
        private Double price;
        private String thumbnailPic;
        private String name;
    }

    @Data
    @Schema(name = "Restaurant2")
    public static class Restaurant {
        private Long id;
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
    }

    @Data
    @Schema(name = "Ingredient2")
    public static class Ingredient {
        private Long id;
        private String name;
        private String thumbnailPic;
        private Double price;
    }
}
