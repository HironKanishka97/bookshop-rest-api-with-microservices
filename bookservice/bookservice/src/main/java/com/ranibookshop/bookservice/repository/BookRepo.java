package com.ranibookshop.bookservice.repository;

import com.ranibookshop.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

    Book findBooksByIsbn(String isbn);
}
