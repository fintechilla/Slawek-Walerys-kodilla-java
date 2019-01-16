package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedian(){
        //Given
        Set<Book> bookListA = new HashSet<>();
        bookListA.add(new Book("Agatha Christie", "Bullet", 2000, "ac1"));
        bookListA.add(new Book("Agatha Christie", "Murder", 1950, "ac11"));
        bookListA.add(new Book("Agatha Christie", "Sherlock", 1970, "ac12"));
        bookListA.add(new Book("Agatha Christie", "Holmes", 1978, "ac13"));
        bookListA.add(new Book("Agatha Christie", "Discovery", 2002, "ac14"));
        bookListA.add(new Book("Agatha Christie", "Secrete", 2004, "ac15"));
        bookListA.add(new Book("Agatha Christie", "Watson", 1966, "ac16"));

        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int result = medianAdapter.publicationYearMedian(bookListA);
        //Then
        assertEquals(1978, result  );


    }
}
