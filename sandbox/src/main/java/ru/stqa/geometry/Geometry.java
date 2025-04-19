package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
        var squares = List.of(new Square(7.0),new Square(5.0),new Square(3.0));
//        for (Square square : squares) {
//            Square.printSquareArea(square);
//        }
//        Consumer<Square> print = Square::printSquareArea;
        squares.forEach(Square::printSquareArea);
        Triangle.printTriangleArea( new Triangle(9, 6, 8));
        Triangle.printTrianglePerimeter(new Triangle(9, 6, 8));

//        Rectangle.printRectangleArea(3.0, 5.0);
//        Rectangle.printRectangleArea(6.0, 7.0);
    }

}
