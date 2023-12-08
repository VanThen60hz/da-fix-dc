package com.dtu.elibrary.service.impl;

import com.dtu.elibrary.model.Category;
import com.dtu.elibrary.repository.CategoryRepository;
import com.dtu.elibrary.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
