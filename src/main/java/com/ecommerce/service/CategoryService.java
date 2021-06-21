package com.ecommerce.service;

import com.ecommerce.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);
    void save(Category category);
    void deleteById(long id);
    void update(long id, Category category);
}
