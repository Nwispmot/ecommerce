package com.ecommerce.repository.specs;

import lombok.Data;

@Data
public class SearchProductFilter {
    private String name;
    private Long categoryId;
}
