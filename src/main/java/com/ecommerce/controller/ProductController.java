package com.ecommerce.controller;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.specs.SearchProductFilter;
import com.ecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    public static final String ADMIN = "ROLE_ADMIN";

    @GetMapping
    public Page<Product> findAll(Pageable pageable){
        return productService.findAll( pageable);
    }

    @GetMapping("/search")
    public Iterable<Product> search(SearchProductFilter filter){
        return productService.search(filter);
    }

    @Secured({ADMIN})
    @PostMapping
    public void save(@RequestBody Product product){
        productService.save(product);
    }

    @Secured({ADMIN})
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        productService.deleteById(id);
    }

    @Secured({ADMIN})
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Product product){
        productService.update(id, product);
    }
}
