package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));
        Triangle.printTriangleArea( new Triangle(9, 6, 8));
        Triangle.printTrianglePerimeter(new Triangle(9, 6, 8));

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(6.0, 7.0);
    }

}
