package com.ranibookshop.bookservice.service;

import com.ranibookshop.bookservice.dto.BookCategoryDto;
import com.ranibookshop.bookservice.dto.BookDto;
import com.ranibookshop.bookservice.entity.Book;
import com.ranibookshop.bookservice.repository.BookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<BookDto> getAllBooks() {
        try {
            List<Book> books = bookRepo.findAll();
            List<BookDto> bookDtos = new ArrayList<>();
            if (!books.isEmpty()) {
                for (Book book : books) {
                    BookCategoryDto bcdto = new BookCategoryDto(book.getCategory().getId(), book.getCategory().getName());
                    BookDto bdto = new BookDto(
                            book.getId(), book.getTitle(), book.getIsbn(), book.getAuthor(), book.getPrice(), bcdto);
                    bookDtos.add(bdto);
                }
                return bookDtos;
            }else{
                return new ArrayList<>();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BookDto getBookByIsbn(String isbn) {
        try {
            Book book = bookRepo.findBooksByIsbn(isbn);
            if (book != null) {
                BookCategoryDto bcdto = new BookCategoryDto(book.getCategory().getId(), book.getCategory().getName());
                return new BookDto(
                        book.getId(), book.getTitle(), book.getIsbn(), book.getAuthor(), book.getPrice(), bcdto);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BookDto getBookById(int id) {
        try {
            Book book = bookRepo.findById(id).orElse(null);
            if (book != null) {
                BookCategoryDto bcdto = new BookCategoryDto(book.getCategory().getId(), book.getCategory().getName());
                return new BookDto(
                        book.getId(), book.getTitle(), book.getIsbn(), book.getAuthor(), book.getPrice(), bcdto);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
