package com.ecommerce.service;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.specs.SearchProductFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    void deleteById(long id);
    void update(long id, Product product);
    Iterable<Product> search(SearchProductFilter productFilter);
}
