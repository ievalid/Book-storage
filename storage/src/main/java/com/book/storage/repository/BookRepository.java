package com.book.storage.repository;

import com.book.storage.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    public Iterable<Book> findAllByOrderByQuantityAscPriceAsc();
    public Iterable<Book> findAllByBarcodeContainingIgnoreCase(String barcode);

}
