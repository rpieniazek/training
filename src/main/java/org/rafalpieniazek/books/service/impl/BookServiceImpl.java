package org.rafalpieniazek.books.service.impl;

import com.google.common.collect.Lists;
import org.rafalpieniazek.books.common.BookSearchCriteria;
import org.rafalpieniazek.books.entity.Book;
import org.rafalpieniazek.books.mapper.BookMapper;
import org.rafalpieniazek.books.repository.BookRepository;
import org.rafalpieniazek.books.service.BookService;
import org.rafalpieniazek.books.to.BookTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private BookMapper bookMapper;

  @Override
  public List<BookTo> findBooks(BookSearchCriteria bookSearchCriteria) {

    List<Book> books = this.bookRepository.findBooks(bookSearchCriteria);
    return this.bookMapper.mapSourceCollection(Lists.newArrayList(books));
  }

  @Override
  public BookTo addBook(BookTo bookTo) {

    return saveBook(bookTo);
  }

  @Override
  public BookTo readBook(long id) {

    Book book = this.bookRepository.findOne(id);
    return this.bookMapper.convertToTransportObject(book);
  }

  @Override
  public boolean deleteBook(long id) {

    boolean deleted = false;
    Book book = this.bookRepository.findOne(id);
    if (book != null) {
      this.bookRepository.delete(book);
      deleted = true;
    }
    return deleted;
  }

  @Override
  public BookTo updateBook(BookTo bookTo) {

    return saveBook(bookTo);
  }

  private BookTo saveBook(BookTo bookTo) {

    Book book = this.bookMapper.convertToEntity(bookTo);
    Book savedBook = this.bookRepository.saveAndFlush(book);
    return this.bookMapper.convertToTransportObject(savedBook);
  }

}
