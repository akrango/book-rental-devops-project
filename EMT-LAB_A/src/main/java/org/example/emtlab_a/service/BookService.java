package org.example.emtlab_a.service;

import org.example.emtlab_a.enumerations.Category;
import org.example.emtlab_a.model.Book;
import org.example.emtlab_a.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);
    Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id,BookDto bookDto);
    void deleteById(Long id);
    boolean borrow(Long id);
    void refreshMaterializedView();
}
