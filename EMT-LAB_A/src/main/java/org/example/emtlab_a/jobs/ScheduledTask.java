package org.example.emtlab_a.jobs;


import org.example.emtlab_a.service.BookService;
import org.example.emtlab_a.view.BooksPerCategoryView;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    private final BookService bookService;

    public ScheduledTask(BookService bookService) {
        this.bookService = bookService;
    }

    @Scheduled(fixedDelay = 5000)
    public void refreshMaterializedView(){
        this.bookService.refreshMaterializedView();
    }
}
