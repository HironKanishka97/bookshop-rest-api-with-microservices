package com.ranibookshop.bookservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false,unique = true)
    private String isbn;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne
    private BookCategory category;

}
