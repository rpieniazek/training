package org.rafalpieniazek.books.mapper;

import java.util.List;

import org.rafalpieniazek.books.entity.Book;
import org.rafalpieniazek.books.to.BookTo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
@DecoratedWith(BookMapperSDecorator.class)
public interface BookMapperS {

  BookMapperS INSTANCE = Mappers.getMapper(BookMapperS.class);

  public abstract BookTo bookToBookTo(Book book);

  public abstract Book bookToToBook(BookTo book);

  public abstract List<BookTo> booksToBookTos(List<Book> books);

}
