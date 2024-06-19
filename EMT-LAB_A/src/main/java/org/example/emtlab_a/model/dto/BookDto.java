package org.example.emtlab_a.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.emtlab_a.enumerations.Category;
import org.example.emtlab_a.model.Author;

@Data
public class BookDto {
    private String name;

    private Category category;

    private Long authorId;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category categoryId, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = categoryId;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
