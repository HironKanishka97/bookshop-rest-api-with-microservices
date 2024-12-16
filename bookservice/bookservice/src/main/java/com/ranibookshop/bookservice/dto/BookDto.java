package com.ranibookshop.bookservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private int id;
    private String title;
    private String isbn;
    private String author;
    private BigDecimal price;
    private BookCategoryDto category;

}
