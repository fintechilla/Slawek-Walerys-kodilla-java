package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    Statistics statistics = new Statistics();

    public int averagePublicationYear(Map<BookSignature, BookB> books){
        return statistics.averagePublicationYear(books);
    };
    public int medianPublicationYear(Map<BookSignature, BookB> books){
        return statistics.medianPublicationYear(books);
    };
}
