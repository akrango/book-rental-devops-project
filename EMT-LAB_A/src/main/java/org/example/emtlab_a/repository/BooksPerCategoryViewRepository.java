package org.example.emtlab_a.repository;

import org.example.emtlab_a.view.BooksPerCategoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BooksPerCategoryViewRepository extends JpaRepository<BooksPerCategoryView, Long>{
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.books_per_category", nativeQuery = true)
    void refreshMaterializedView();
}
