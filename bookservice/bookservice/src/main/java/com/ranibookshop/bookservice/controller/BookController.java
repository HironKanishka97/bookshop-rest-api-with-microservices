package com.ranibookshop.bookservice.controller;

import com.ranibookshop.bookservice.dto.BookDto;
import com.ranibookshop.bookservice.dto.ResponseDto;
import com.ranibookshop.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("api/v1/books/"))
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("getAllBooks")
    public ResponseEntity<ResponseDto> getAllBooks() {
        List<BookDto> allBooks = bookService.getAllBooks();
        if(!allBooks.isEmpty()){
            return new ResponseEntity<ResponseDto>(
            new ResponseDto(200, "all books fetched successfully", allBooks), HttpStatus.OK
            );
        }else{
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(204, "Book List Empty", allBooks), HttpStatus.NO_CONTENT
            );
        }
    }
    @GetMapping("getBookByIsbn/{isbn}")
    public ResponseEntity<ResponseDto> getBookByIsbn(@PathVariable String isbn) {
      BookDto book =  bookService.getBookByIsbn(isbn);
        System.out.println(book);
      if(book != null){
          return new ResponseEntity<ResponseDto>(
                  new ResponseDto(200, "Book fetched successfully", book), HttpStatus.OK
          );
      }else{
          return new ResponseEntity<ResponseDto>(
                  new ResponseDto(404, "Book Not Found"), HttpStatus.NOT_FOUND
          );
      }

    }

    @GetMapping("getBookById/{id}")
    public ResponseEntity<ResponseDto> getBookById(@PathVariable int id) {
        BookDto book =  bookService.getBookById(id);
        if(book != null){
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(200, "Book fetched successfully", book), HttpStatus.OK
            );
        }else{
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(404, "Book Not Found"), HttpStatus.NOT_FOUND
            );
        }

    }


}
