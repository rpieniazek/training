package org.rafalpieniazek.books.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.rafalpieniazek.books.entity.Book;
import org.rafalpieniazek.books.repository.AuthorRepository;
import org.rafalpieniazek.books.to.BookTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public abstract class BookMapperSDecorator implements BookMapperS {

  @Autowired
  @Qualifier("delegate")
  private BookMapperS delegate;

  @Autowired
  private AuthorRepository authorRepository;

  @Override
  public BookTo bookToBookTo(Book book) {

    BookTo to = this.delegate.bookToBookTo(book);
    to.setAuthor(book.getAuthors().stream().map(author -> author.getPersonalData().getLastName())
        .collect(Collectors.joining(", ")));
    return to;
  }

  @Override
  public Book bookToToBook(BookTo bookTo) {

    Book book = this.delegate.bookToToBook(bookTo);
    String author = bookTo.getAuthor();
    if (StringUtils.hasText(author)) {
      book.addAuthor(this.authorRepository.findByLastName(author));
    }
    return book;
  }

  @Override
  public List<BookTo> booksToBookTos(List<Book> books) {

    return books.stream().map(this::bookToBookTo).collect(Collectors.toList());
  }
}
