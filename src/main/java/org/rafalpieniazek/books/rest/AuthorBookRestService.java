package org.rafalpieniazek.books.rest;

import org.rafalpieniazek.books.service.AuthorService;
import org.rafalpieniazek.books.to.AuthorTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/services")
@RestController
public class AuthorBookRestService {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<AuthorTo> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
