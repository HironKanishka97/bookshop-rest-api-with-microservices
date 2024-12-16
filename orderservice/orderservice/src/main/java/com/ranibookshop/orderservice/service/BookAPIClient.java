package com.ranibookshop.orderservice.service;

import com.ranibookshop.orderservice.dto.BookDto;
import com.ranibookshop.orderservice.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "BOOK-SERVICE")
public interface BookAPIClient {

    @GetMapping("/api/v1/books/getBookByIsbn/{isbn}")
    ResponseEntity<ResponseDto<BookDto>> getBookByIsbn(@PathVariable String isbn);

}
