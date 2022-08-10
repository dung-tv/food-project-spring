package com.main.food.modules.admin.entity;

import com.main.food.modules.common.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin_users")
@NoArgsConstructor
@Data
public class Admin extends User {

}
