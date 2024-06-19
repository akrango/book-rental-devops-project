////package org.example.emtlab_a.web.controller;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.example.emtlab_a.enumerations.Category;
//import org.example.emtlab_a.model.Author;
//import org.example.emtlab_a.model.Book;
//import org.example.emtlab_a.service.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/books")
//public class BookController {
//
//    private final BookService bookService;
//    private final AuthorService authorService;
//    private final CountryService countryService;
//
//    public BookController(BookService bookService, AuthorService authorService, CountryService countryService){
//        this.bookService = bookService;
//        this.authorService = authorService;
//        this.countryService = countryService;
//    }
//
//    @GetMapping
//    public String listBooks(@RequestParam(required = false) String error, Model model){
//        if(error!=null && !error.isEmpty()){
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", error);
//        }
//        model.addAttribute("books", bookService.findAll());
//        model.addAttribute("bodyContent", "books");
//        return "master-template";
//    }
//
//    @DeleteMapping("delete/{id}")
//    public String deleteBook(@PathVariable Long id, Model model){
//        this.bookService.deleteById(id);
//        return "redirect:/books";
//    }
//
//    @GetMapping("add-form")
//    public String addBook(Model model){
//        model.addAttribute("bodyContent", "add-product");
//        model.addAttribute("categories", Category.values());
//        model.addAttribute("authors", authorService.findAll());
//        return "master-template";
//    }
//
//    @PostMapping("add")
//    public String saveBook(
//            @RequestParam(required = false) Long id,
//            @RequestParam String name,
//            @RequestParam Category category,
//            @RequestParam Long author,
//            @RequestParam Integer copies){
//        Author auth=authorService.findById(author).get();
//        if (id != null) {
//            this.bookService.edit(id, name, category, author, copies);
//        } else {
//            this.bookService.save(name, category, author, copies);
//        }
//        return "redirect:/books";
//    }
//
//    @GetMapping("edit-form/{id}")
//    public String editBook(@PathVariable Long id, Model model){
//        if(this.bookService.findById(id).isPresent()){
//            Book book = this.bookService.findById(id).get();
//            model.addAttribute("categories", Category.values());
//            model.addAttribute("authors", authorService.findAll());
//            model.addAttribute("book", book);
//            model.addAttribute("bodyContent", "add-product");
//            return "master-template";
//        }
//        return "redirect:/books?error=BookNotFound";
//    }
//
//    @PostMapping("/rent/{id}")
//    public String borrowBook(@PathVariable Long id, HttpServletRequest req){
//        try{
//
//            this.bookService.borrow(id);
//            try {
//            }catch (RuntimeException exception){
//                return "redirect:/books?error="+exception.getMessage();
//            }
//            return "redirect:/books";
//        }catch (RuntimeException exception){
//            return "redirect:/books/error="+exception.getMessage();
//        }
//    }
//
////    @GetMapping("/cart")
////
////    public String getBorrowedBooks(HttpServletRequest req, Authentication authentication, Model model){
////        try{
////            User user=(User)authentication.getPrincipal();
////            List<Book> borrowedBooks=user.getBorrowed();
////            model.addAttribute("books", borrowedBooks);
////            model.addAttribute("bodyContent", "shopping-cart");
////        }catch (RuntimeException exception){
////            return "redirect:/books/error="+exception.getMessage();
////        }
////        return "master-template";
////    }
//}
