package org.example.emtlab_a.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.springframework.data.jpa.repository.Query;

@Data
@Entity
@Subselect("SELECT * FROM public.books_per_category")
@Immutable
public class BooksPerCategoryView {
    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "num_books")
    private Integer numBooks;
}
