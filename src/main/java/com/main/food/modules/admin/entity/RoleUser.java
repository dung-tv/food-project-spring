package com.main.food.modules.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.food.base.BaseEntity;
import com.main.food.modules.common.entity.User;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
@Table(name = "admin_roles")
public class RoleUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private String description;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @Fetch(value = FetchMode.SUBSELECT)
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<User> users;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "admin_roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<PrivilegeUser> privileges;
}
