package com.ranibookshop.bookservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookCategoryDto {

    private int id;
    private String name;
//    private List<BookDto> books;

}
