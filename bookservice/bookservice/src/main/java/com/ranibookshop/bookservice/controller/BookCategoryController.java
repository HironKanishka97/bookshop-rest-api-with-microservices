package com.ranibookshop.bookservice.controller;

import com.ranibookshop.bookservice.dto.BookCategoryDto;
import com.ranibookshop.bookservice.dto.ResponseDto;
import com.ranibookshop.bookservice.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("api/v1/bookcategories/"))
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping("getAllBookCategories")
    public ResponseEntity<ResponseDto> getAllBookCategories() {
        List<BookCategoryDto> allBookCategories = bookCategoryService.getAllBookCategories();
        if(!allBookCategories.isEmpty()){
            return new ResponseEntity<ResponseDto>(
            new ResponseDto(200, "all book categories fetched successfully", allBookCategories), HttpStatus.OK
            );
        }else{
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(204, "BookCategory List Empty", allBookCategories), HttpStatus.NO_CONTENT
            );
        }
    }


    @GetMapping("getBookCategoryById/{id}")
    public ResponseEntity<ResponseDto> getBookCategoryById(@PathVariable int id) {
        BookCategoryDto book =  bookCategoryService.getBookCategoryById(id);
        if(book != null){
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(200, "Book Category fetched successfully", book), HttpStatus.OK
            );
        }else{
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(404, "Book Category Not Found"), HttpStatus.NOT_FOUND
            );
        }

    }


}
