package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public  void readFile() throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        System.out.println("Path: " + file.getPath());
        //Path path = ;//file.getPath()
        try (Stream<String> fileLines = Files.lines(Paths.get("file/text.txt"));) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            //e.printStackTrace();
            throw new FileReaderException();
//            System.out.println("Oh no! Something went wrong! Message: " + e);
        } finally {
            System.out.println("I am gonna be here... always");
        }

    }
}
