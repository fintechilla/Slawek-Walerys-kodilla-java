package com.kodilla.good.patterns.challenges.movie;

import java.util.stream.Collectors;

public class MovieStoreProcessor {

    public static void main(String[] args) {
        System.out.println(MovieStore.getMovies().entrySet().stream()
                .flatMap(m->m.getValue().stream())
                .collect(Collectors.joining("!","!","!")));

    }
}
