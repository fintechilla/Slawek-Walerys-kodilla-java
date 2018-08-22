package com.kodilla.stream;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

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

    }

    private static String decorate(String a) {
        String result = "";
        if(a.contains("ice")){
            result = "Cold day";
        }
        return result;
    }
}
