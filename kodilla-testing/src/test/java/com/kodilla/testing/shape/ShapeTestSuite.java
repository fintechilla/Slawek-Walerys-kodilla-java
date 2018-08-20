package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeTestSuite {
    private  static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests finished");
    }

    @Before
    public void beforeEveryTest(){
        testCounter ++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

//    @After
//    public void afterEveryTest(){
//        System.out.println("End of test #" + testCounter);
//    }

    @Test //Test 1 - add figure, shapeCounter should be increased by 1
    public void testAddShape(){
        //Given
        ShapeCollector shapes;
        shapes = new ShapeCollector();
        Square square = new Square(23.0);

        //When
        shapes.addFigure(square);

        //Then
        Assert.assertEquals(1, shapes.getShapesQuantity());
    }
    @Test //Test 2 - insert a figure, then remove it , are they the same?
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapes;
        shapes = new ShapeCollector();
        Shape square = new Square(23.0);

        //When
        shapes.addFigure(square);
        boolean result = shapes.removeFigure(square);
        int resultSize = shapes.getShapesQuantity();

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, resultSize);
    }
    @Test //Test 3 - will remove a non-existing post give false
    public void testRemoveShapeNonExistent(){
        //Given
        Square square = new Square(23.0);
        Shape triangle = new Triangle(15.1);
        ShapeCollector shapes = new ShapeCollector();
        shapes.addFigure(square);

        //When
        boolean result = shapes.removeFigure(triangle);
        int resultSize = shapes.getShapesQuantity();

        //Then
        Assert.assertFalse(result);
        Assert.assertEquals(1,resultSize);
    }
    @Test //Test 4 - pobieranie elementu by index
    public void testGetShapeByIndex(){
        //Given
        Square square = new Square(23.0);
        Shape triangle = new Triangle(15.1);
        ShapeCollector shapes = new ShapeCollector();
        shapes.addFigure(square);

        //When
        Shape result = shapes.getFigure(0);

        //Then
        Assert.assertEquals(square,result);
    }
}
