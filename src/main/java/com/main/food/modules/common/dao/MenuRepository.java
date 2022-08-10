package com.main.food.modules.common.dao;

import com.main.food.base.BaseDao;
import com.main.food.modules.common.entity.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends BaseDao<Menu, Long> {
}
