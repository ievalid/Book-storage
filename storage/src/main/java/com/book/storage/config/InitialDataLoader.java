package com.book.storage.config;

import com.book.storage.model.Book;
import com.book.storage.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Component
@Profile({ "default", "test" })
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final static Logger log = LoggerFactory.getLogger(InitialDataLoader.class);

    @Autowired
    private BookService bookService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (bookService.count() > 0) {
            log.info("Database already populated. Skipping data initialization.");
            return;
        }

        bookService.saveBook(new Book("Pepe ilgakojine", "Astrida Lingren", "12222222111", 1, 12));
        bookService.saveBook(new Book("Aušvico lopšinė", "Mario Escobar", "111112", 3, 14));
        bookService.saveBook(new Book("Mažasis princas", "Antoine de Saint-Exupery", "13333", 3, 16));
        bookService.saveBook(new Book("Maisto ragautoja", "V.S. Alexander", "22231", 1, 6));
    }
}
