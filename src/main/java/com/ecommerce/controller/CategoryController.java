package com.ecommerce.controller;

import com.ecommerce.entity.Category;
import com.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    public static final String ADMIN = "ROLE_ADMIN";

    @GetMapping
    public Page<Category> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @Secured({ADMIN})
    @PostMapping
    public void save(@RequestBody Category category){
        service.save(category);
    }

    @Secured({ADMIN})
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        service.deleteById(id);
    }


    @Secured({ADMIN})
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Category category){
        service.update(id, category);
    }

}
