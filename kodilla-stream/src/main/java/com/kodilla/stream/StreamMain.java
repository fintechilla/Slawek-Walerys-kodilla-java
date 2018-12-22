package com.kodilla.stream;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

//        SaySomething saySomething = new SaySomething();
//        saySomething.say();
        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);
        processor.execute(()->System.out.println("Hello"));

        System.out.println("Calculating expressions with lambdas");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        double c = 2;
        double d = 3;
        expressionExecutor.executeExpression(c, d, ((a, b)-> a + b));
        expressionExecutor.executeExpression(c, d, ((a, b)-> a - b));
        expressionExecutor.executeExpression(c, d, ((a, b)-> a * b));
        expressionExecutor.executeExpression(c, d, ((a, b)-> a / b));

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(c, d, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(c, d, FunctionalCalculator::subtractBFromA);
        expressionExecutor.executeExpression(c, d, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(c, d, FunctionalCalculator::divideAByB);

        //Exercise 7.1 - Text Beautifier
        String text = "Nice day";
        System.out.println("Exercise 7.1 - Text Beautifier");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("ABC", ((a)-> a + text + a) );
        poemBeautifier.beautify(text, ((a)->a.toUpperCase()) );
        poemBeautifier.beautify(text, (StreamMain::decorate));
        poemBeautifier.beautify(text, ((a)->{
            String result ="";
            for(int i = 0; i < a.length(); i++){
                result += a.charAt(i) + "/";
            }
            return result;
        }) );
        poemBeautifier.beautify(text, ((a)->{
            String result = "";
            if(a.contains("ice")){
                result = "Cold day";
            }
            return result;
        }) );

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
        System.out.println("Begin module 7.3------------------");

        People.getList().stream()
                .forEach(System.out::print);
        People.getList().stream()
                .map(s->s.toUpperCase())
                .filter(s->s.length()>11)
                .forEach(System.out::println);
        System.out.println("Continue module 7.3");

        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book->book.getYearOfPublication() > 15)
                .forEach(System.out::println);
        System.out.println("7.3 Collectors.toList()-----------------");
        List<Book> theResultListOfBooks =
                theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# of elements in the bookList: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        System.out.println("\"7.3 Collectors.toMap()-----------------\"");
        Map<String, Book>theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));
        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println("\"7.3 Collectors.joining()-----------------\"");
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication()>2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
    }

    private static String decorate(String a) {
        String result = "";
        if(a.contains("ice")){
            result = "Cold day";
        }
        return result;
    }
}
