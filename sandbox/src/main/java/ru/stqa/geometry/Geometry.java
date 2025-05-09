package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.0));
        var squares = Stream.generate(randomSquare).limit(5);
//        for (Square square : squares) {
//            Square.printSquareArea(square);
//        }
//        Consumer<Square> print = Square::printSquareArea;
        squares.peek(Square::printSquareArea).forEach(Square::printSquareArea);
        Triangle.printTriangleArea( new Triangle(9, 6, 8));
        Triangle.printTrianglePerimeter(new Triangle(9, 6, 8));

//        Rectangle.printRectangleArea(3.0, 5.0);
//        Rectangle.printRectangleArea(6.0, 7.0);
    }

}
