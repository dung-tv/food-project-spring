package com.main.food.modules.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.food.modules.customer.entity.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Restaurant name is required")
    @NotBlank(message = "Restaurant name shouldn't be blank")
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "categories_restaurants",
            joinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Collection<com.main.food.modules.common.entity.Category> categories;

    @OneToMany(mappedBy = "restaurant")
    private Collection<com.main.food.modules.common.entity.Menu> menus;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private Collection<com.main.food.modules.common.entity.Order> orders;

    @JsonIgnore
    @ManyToMany(mappedBy = "restaurantsFavorite")
    private Collection<Customer> customersFavorite;
}
