package org.example.emtlab_a.repository;

import org.example.emtlab_a.model.Author;
import org.example.emtlab_a.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
