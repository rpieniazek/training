package org.rafalpieniazek.books.repository;

import org.rafalpieniazek.books.common.BookSearchCriteria;
import org.rafalpieniazek.books.entity.Book;

import java.util.List;

public interface BookSearchRepository {

    List<Book> findBooks(BookSearchCriteria bookSearchCriteria);
}
