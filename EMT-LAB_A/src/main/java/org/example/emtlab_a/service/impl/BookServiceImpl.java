package org.example.emtlab_a.service.impl;

import org.example.emtlab_a.exceptions.AuthorNotFoundException;
import org.example.emtlab_a.exceptions.BookNotFoundException;
import org.example.emtlab_a.model.Author;
import org.example.emtlab_a.model.Country;
import org.example.emtlab_a.model.dto.BookDto;
import org.example.emtlab_a.repository.AuthorRepository;
import org.example.emtlab_a.repository.BookRepository;
import org.example.emtlab_a.enumerations.Category;
import org.example.emtlab_a.model.Book;
import org.example.emtlab_a.repository.BooksPerCategoryViewRepository;
import org.example.emtlab_a.service.BookService;
import org.example.emtlab_a.view.BooksPerCategoryView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BooksPerCategoryViewRepository booksPerCategoryViewRepository;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BooksPerCategoryViewRepository booksPerCategoryViewRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.booksPerCategoryViewRepository = booksPerCategoryViewRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = new Book(name, category, author, availableCopies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        book.setName(name);
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book = new Book(bookDto.getName(),bookDto.getCategory(), author, bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        book.setName(book.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        return Optional.of(this.bookRepository.save(book));
    }


    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public boolean borrow(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        if (book.getAvailableCopies()<=0)
            return false;
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);
        return true;
    }

    @Override
    public void refreshMaterializedView() {
        this.booksPerCategoryViewRepository.refreshMaterializedView();
    }
}
