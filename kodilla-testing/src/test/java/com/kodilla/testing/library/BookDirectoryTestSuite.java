package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    @Test //Test 1
    public void testListOfBooksWithConditionsReturnLists() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        assertEquals(resultListOfBooks.size(), theListOfBooks.size());
    }

    @Test //Test 2
    public void testListOfBooksWithConditionsMoreThan20Books() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test //Test 3
    public void testListOfBooksWithFragmentsShorterThan3Characters() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);

        //When
        List<Book> theListOf10Books = bookLibrary.listBooksWithCondition("An");
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        //Then
        assertEquals(0, theListOf10Books.size());
        assertEquals(10, theListOfBooks0.size());
        assertEquals(10, theListOfBooks15.size());
        assertEquals(10, theListOfBooks40.size());

        verify(libraryDatabaseMock, times(3)).listBooksWithCondition(anyString());
    }

    @Test //Test - 4
    public void testListOfBooksInHandsOfBookUser() {
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> expectedResultListOfBooks0 = generateListOfNBooks(0);
        List<Book> expectedResultListOfBooks5 = generateListOfNBooks(5);
        List<Book> expectedResultListOfBooks10 = generateListOfNBooks(10);

        LibraryUser libraryUser0 = new LibraryUser("John","Smith", "12345678");
        LibraryUser libraryUser5 = new LibraryUser("Mary","Miller", "12345678");
        LibraryUser libraryUser10 = new LibraryUser("Adam","Smith", "12345678");

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser0)).thenReturn(expectedResultListOfBooks0);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5)).thenReturn(expectedResultListOfBooks5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser10)).thenReturn(expectedResultListOfBooks10);

        //When
        List<Book> resultListOfBooksInHands0 = bookLibrary.listBooksInHandsOf(libraryUser0);
        List<Book> resultListOfBooksInHands5 = bookLibrary.listBooksInHandsOf(libraryUser5);
        List<Book> resultListOfBooksInHands10 = bookLibrary.listBooksInHandsOf(libraryUser10);


        //Then
        assertEquals(expectedResultListOfBooks0.size(), resultListOfBooksInHands0.size());
        assertEquals(expectedResultListOfBooks5.size(), resultListOfBooksInHands5.size());
        assertEquals(expectedResultListOfBooks10.size(), resultListOfBooksInHands10.size());

        verify(libraryDatabaseMock, times(3)).listBooksInHandsOf(any());
//        verify(libraryDatabaseMock, times(5)).listBooksInHandsOf(any());
//        verify(libraryDatabaseMock, times(10)).listBooksInHandsOf(any());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int i = 0; i < booksQuantity; i++) {
            Book theBook = new Book("Title" + i, "Author" + i, 1970 + i);
            resultList.add(theBook);
        }
        return resultList;
    }
}

