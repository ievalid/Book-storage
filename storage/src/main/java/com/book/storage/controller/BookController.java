package com.book.storage.controller;

import com.book.storage.model.Book;
import com.book.storage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping(value = {"/books"}, produces = { MediaType.TEXT_HTML_VALUE })
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String viewHomePage(Model model, @RequestParam (value = "search_term", required = false) String search_term){
        if ((search_term == null) || (search_term.equals(""))) {
            model.addAttribute("listBooks", bookService.findAllByOrderByQuantityAscPriceAsc());
            return "books/index";
        }else{
            Iterable<Book> bookByBarcode = bookService.findAllByBarcodeContainingIgnoreCase(search_term);
            model.addAttribute("bookInfo", bookByBarcode);
            return "books/search-results";
        }
    }

    @GetMapping("/new")
    public String newBook(Model model){

        if(!model.containsAttribute("book")) {
            Book book = new Book();
            model.addAttribute("book", book);
        }

        return "books/newBook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id){
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id, Model model){

        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);

        return "books/updateBook";
    }

    @PostMapping(name="/saveBook",path="/saveBook", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveBook(@RequestBody @Valid @ModelAttribute("book") Book book, BindingResult errors,
                               Model model, RedirectAttributes redirectAttrs){

        if(errors.hasErrors()){
            model.addAttribute("book", book);

            return "/new";
        }

        bookService.saveBook(book);
        return "redirect:/books";
    }
}
