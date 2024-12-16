package com.ranibookshop.bookservice.service;

import com.ranibookshop.bookservice.dto.BookCategoryDto;
import com.ranibookshop.bookservice.entity.BookCategory;
import com.ranibookshop.bookservice.repository.BookCategoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookCategoryService {

    @Autowired
    private BookCategoryRepo bookcategoryRepo;

    public List<BookCategoryDto> getAllBookCategories() {
        try {
            List<BookCategory> bookcategories = bookcategoryRepo.findAll();
            List<BookCategoryDto> bookcategoryDtos = new ArrayList<>();
            if(!bookcategories.isEmpty()) {
                for (BookCategory bookcategory : bookcategories) {
                    BookCategoryDto bookcategoryDto = new BookCategoryDto(
                            bookcategory.getId(),bookcategory.getName()
                    );
                    bookcategoryDtos.add(bookcategoryDto);
                }
                return bookcategoryDtos;
            }else{
                return new ArrayList<>();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BookCategoryDto getBookCategoryById(int id) {
        try {
            BookCategory bookcategory = bookcategoryRepo.findById(id).orElse(null);
            if (bookcategory != null) {
                return new BookCategoryDto(bookcategory.getId(), bookcategory.getName());
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
