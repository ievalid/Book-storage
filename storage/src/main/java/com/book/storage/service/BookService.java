package com.book.storage.service;

import com.book.storage.model.Book;

public interface BookService {
    public Iterable<Book> getAllBooks();
    void saveBook(Book book);
    public Book getBookById(long id);
    void deleteBookById(long id);
    public Iterable<Book> findAllByOrderByQuantityAscPriceAsc();

    public Iterable<Book> findAllByBarcodeContainingIgnoreCase(String barcode);
    public long  count();
}
