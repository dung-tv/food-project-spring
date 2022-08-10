package com.main.food.modules.customer.entity;

import com.main.food.modules.common.entity.Order;
import com.main.food.modules.common.entity.Restaurant;
import com.main.food.modules.common.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
@Table(name = "customer_users")
public class Customer extends User {

    private String location;

    private String city;

    private String street;

    private String house;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "customers_restaurants_favorite",
            joinColumns = @JoinColumn(
                    name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "restaurant_id", referencedColumnName = "id"))
    private Collection<Restaurant> restaurantsFavorite;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "customer")
    private Collection<Order> orders;
}
