package com.main.food.modules.customer.dto.response;

import com.main.food.modules.admin.dto.response.AdminResDto;
import com.main.food.modules.common.dto.response.OrderResDto;
import com.main.food.modules.common.entity.Restaurant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collection;

@Data
@Schema(name = "CustomerResDto")
public class CustomerResDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean enabled;
    private boolean tokenExpired;
    private String location;
    private String city;
    private String street;
    private String house;
    private Collection<AdminResDto.RoleUser> roles;
    private Collection<OrderResDto> orders;
    private Collection<Restaurant> restaurantsFavorite;
}
