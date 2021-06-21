package com.ecommerce.service.impl;

import com.ecommerce.entity.Product;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.specs.ProductSpecs;
import com.ecommerce.repository.specs.SearchProductFilter;
import com.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productsRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productsRepository.save(product);
    }

    @Override
    public void deleteById(long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public void update(long id, Product product) {
        Product old = productsRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        old.setName(product.getName());
        productsRepository.save(old);
    }

    @Override
    public Iterable<Product> search(SearchProductFilter filter) {
        return productsRepository.findAll(ProductSpecs.withFilter(filter));
    }

}
