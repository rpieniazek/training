package org.rafalpieniazek.books.mapper;

import org.rafalpieniazek.books.entity.Author;
import org.rafalpieniazek.books.to.AuthorTo;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapperS {

  Author authorToToAuthor(AuthorTo authorTo);

  AuthorTo authorToAuthorTo(Author author);

}
