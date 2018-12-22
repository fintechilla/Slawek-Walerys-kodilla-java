package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {
    public  void readFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        System.out.println("Path: " + file.getPath());
        //Path path = ;//file.getPath()

        Stream<String> fileLines = Files.lines(Paths.get("file/text.txt"));
        fileLines.forEach(System.out::println);
    }
}
