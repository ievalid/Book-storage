package com.book.storage.service;

import com.book.storage.model.Book;
import com.book.storage.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> optional = bookRepository.findById(id);
        Book book = null;

        if(optional.isPresent()){
            book=optional.get();
        }else{
            throw new RuntimeException("Book not found for id :: " + id);
        }

        return book;
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Iterable<Book> findAllByOrderByQuantityAscPriceAsc() {
        return bookRepository.findAllByOrderByQuantityAscPriceAsc();
    }

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    public Iterable<Book> findAllByBarcodeContainingIgnoreCase(String barcode){
        return bookRepository.findAllByBarcodeContainingIgnoreCase(barcode);
    }
}
