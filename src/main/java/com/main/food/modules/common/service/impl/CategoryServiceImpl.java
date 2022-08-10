package com.main.food.modules.common.service.impl;

import com.main.food.modules.common.dao.CategoryRepository;
import com.main.food.modules.common.mapper.CategoryMapper;
import com.main.food.modules.common.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryRepository getRepository() {
        return categoryRepository;
    }

    @Override
    public CategoryMapper getMapper() {
        return categoryMapper;
    }
}
