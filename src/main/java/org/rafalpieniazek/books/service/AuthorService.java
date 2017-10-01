package org.rafalpieniazek.books.service;

import org.rafalpieniazek.books.entity.Author;
import org.rafalpieniazek.books.mapper.AuthorMapper;
import org.rafalpieniazek.books.repository.AuthorRepository;
import org.rafalpieniazek.books.to.AuthorTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorTo> getAllAuthors() {
        List<Author> allAuthors = authorRepository.findAll();
        return authorMapper.mapSourceCollection(allAuthors);

    }
}
