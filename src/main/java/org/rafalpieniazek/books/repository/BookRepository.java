package org.rafalpieniazek.books.repository;

import org.rafalpieniazek.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, BookSearchRepository {

}
