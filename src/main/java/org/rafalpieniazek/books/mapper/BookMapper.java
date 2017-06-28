package org.rafalpieniazek.books.mapper;

import org.rafalpieniazek.books.entity.Book;
import org.rafalpieniazek.books.repository.AuthorRepository;
import org.rafalpieniazek.books.to.BookTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;

@Component
public class BookMapper extends AbstractMapper<Book, BookTo> {

    private final AuthorRepository authorRepository;

    @Autowired
    public BookMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public BookTo convertToTransportObject(Book source) {
        BookTo book = null;
        if (source != null) {
            book = new BookTo();
            book.setId(source.getId());
            book.setTitle(source.getTitle());
            book.setAuthor(source.getAuthors().stream().map(author -> author.getPersonalData().getLastName()).collect(Collectors.joining(", ")));
            book.setGenre(source.getGenre());
            book.setVersion(source.getVersion());
            book.setYear(source.getYear());
        }
        return book;
    }

    @Override
    public Book convertToEntity(BookTo target) {
        Book book = null;
        if (target != null) {
            book = new Book(target.getId(), target.getTitle());
            book.setVersion(target.getVersion());
            book.setGenre(target.getGenre());
            String author = target.getAuthor();
            if (StringUtils.hasText(author)) {
                book.addAuthor(authorRepository.findByLastName(author));
            }
            book.setYear(target.getYear());
        }
        return book;
    }

}
