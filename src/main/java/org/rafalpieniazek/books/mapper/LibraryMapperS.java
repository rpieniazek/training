package org.rafalpieniazek.books.mapper;

import org.rafalpieniazek.books.entity.Library;
import org.rafalpieniazek.books.to.LibraryTo;
import org.mapstruct.Mapper;

@Mapper(uses = BookMapperS.class)
public interface LibraryMapperS {
  Library libraryToToLibrary(LibraryTo libraryTo);

  LibraryTo libraryToLibraryTo(Library library);

}
