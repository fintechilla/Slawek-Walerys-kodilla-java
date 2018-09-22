package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks(){
        //Given
        Book book1 = new Book("Qou Vadis", "Sienkiewicz", LocalDate.of(2000, 01, 01));
        Book book2 = new Book("King", "Howard", LocalDate.of(2004, 01, 01));
        Book book3 = new Book("Queen", "Smith", LocalDate.of(2005, 01, 01));
        Book book4 = new Book("Prince", "Baker", LocalDate.of(2006, 01, 01));
        Book book5 = new Book("Priincess", "Gordon", LocalDate.of(2007, 01, 01));

        Library library = new Library("Initial");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        Library library1 = library;
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Shallow Cloned");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deepClonedlibrary = null;
        try {
            deepClonedlibrary = library.deepCopy();
            deepClonedlibrary.setName("Deep Cloned");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Printing libraries...");
        System.out.println(library1);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedlibrary);
        //When
        library.getBooks().remove(book1);
        //Then
        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, clonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedlibrary.getBooks().size());
    }
}
