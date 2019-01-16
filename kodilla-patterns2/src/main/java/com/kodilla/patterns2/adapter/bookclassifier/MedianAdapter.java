package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookB;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, BookB> booksMap = new HashMap<>();
        for (Book book : bookSet) {
            booksMap.put(new BookSignature(book.getSignature()), new BookB(book.getTitle(), book.getAuthor(), book.getPublicationYear()));
        }
        return medianPublicationYear(booksMap);
    }
}


