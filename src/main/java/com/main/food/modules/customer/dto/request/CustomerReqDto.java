package com.main.food.modules.customer.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
public class CustomerReqDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;
    private String location;
    private String city;
    private String street;
    private String house;
    private Collection<Restaurant> restaurantsFavorite;

    @Data
    @Schema(name = "Restaurant2")
    public static class Restaurant {
        @NotNull
        private Long id;
    }
}
