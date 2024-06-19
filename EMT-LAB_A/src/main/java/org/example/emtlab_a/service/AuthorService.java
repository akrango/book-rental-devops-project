package org.example.emtlab_a.service;

import org.example.emtlab_a.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(String name, String surname, Long countryId);

    Optional<Author> edit(Long id, String name, String surname, Long countryId);

    void delete(Long id);
}
