package org.rafalpieniazek.books.repository;

import org.rafalpieniazek.books.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
