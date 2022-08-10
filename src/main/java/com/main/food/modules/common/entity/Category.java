package com.main.food.modules.common.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private String thumbnailPic;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Fetch(value = FetchMode.SUBSELECT)
    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Restaurant> restaurants;
}
