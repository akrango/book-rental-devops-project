package org.example.emtlab_a.exceptions;

public class BookAlreadyBorrowed extends RuntimeException{
    public BookAlreadyBorrowed(Long id) {
        super(String.format("Book with id %d is already borrowed", id));
    }
}
