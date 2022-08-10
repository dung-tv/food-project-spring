package com.main.food.modules.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.food.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
@Table(name = "admin_privileges")
public class PrivilegeUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private String description;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "privileges", fetch = FetchType.EAGER)
    private Collection<RoleUser> roles;
}