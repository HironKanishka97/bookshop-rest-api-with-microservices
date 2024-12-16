package com.ranibookshop.bookservice.repository;

import com.ranibookshop.bookservice.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepo extends JpaRepository<BookCategory, Integer> {

}
