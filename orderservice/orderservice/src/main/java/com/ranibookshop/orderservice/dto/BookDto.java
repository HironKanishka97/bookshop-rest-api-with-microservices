package com.ranibookshop.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.String;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private int id;
    private java.lang.String title;
    private java.lang.String isbn;
    private String author;
    private BigDecimal price;
    private BookCategoryDto category;

}
