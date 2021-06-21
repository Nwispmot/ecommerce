package com.ecommerce.repository.specs;

import com.ecommerce.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;


public class ProductSpecs {

    public static Specification<Product> withFilter(SearchProductFilter filter){
        return (Specification<Product>)(root, query,builder)->{
            final Collection<Predicate> predicates = new ArrayList<>();

            if(filter.getName() != null) {
            Predicate nameWith = builder.like(root.get("name"), "%" + filter.getName() + "%");
            predicates.add(nameWith);
            }

            if (filter.getCategoryId() != null){
            Predicate categoryIdWith = builder.equal(root.get("categoryId"), filter.getCategoryId());
            predicates.add(categoryIdWith);
            }
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }
}

