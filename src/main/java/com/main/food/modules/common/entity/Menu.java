package com.main.food.modules.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    private String thumbnailPic;

    @NotNull(message = "Menu name is required")
    @NotBlank(message = "Menu name shouldn't be blank")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "menus")
    private Collection<Ingredient> ingredients;

    @JsonIgnore
    @ManyToMany(mappedBy = "menus")
    private Collection<Order> orders;
}
