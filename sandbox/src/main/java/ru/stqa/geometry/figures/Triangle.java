package ru.stqa.geometry.figures;

import java.util.Objects;

public class Triangle {

    public float firstSide;

    public float secondSide;

    public float thirdSide;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Float.compare(firstSide, triangle.firstSide) == 0 && Float.compare(secondSide, triangle.secondSide) == 0 && Float.compare(thirdSide, triangle.thirdSide) == 0)
                || (Float.compare(firstSide, triangle.secondSide) == 0 && Float.compare(secondSide, triangle.thirdSide) == 0 && Float.compare(thirdSide, triangle.firstSide) == 0)
                || (Float.compare(firstSide, triangle.thirdSide) == 0 && Float.compare(secondSide, triangle.firstSide) == 0 && Float.compare(thirdSide, triangle.secondSide) == 0)
                || (Float.compare(firstSide, triangle.firstSide) == 0 && Float.compare(secondSide, triangle.thirdSide) == 0 && Float.compare(thirdSide, triangle.secondSide) == 0)
                || (Float.compare(firstSide, triangle.secondSide) == 0 && Float.compare(secondSide, triangle.firstSide) == 0 && Float.compare(thirdSide, triangle.thirdSide) == 0)
                || (Float.compare(firstSide, triangle.thirdSide) == 0 && Float.compare(secondSide, triangle.secondSide) == 0 && Float.compare(thirdSide, triangle.firstSide) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public Triangle(float firstSide, float secondSide, float thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;

        if (firstSide < 0 || secondSide < 0 || thirdSide < 0) {
            throw new IllegalArgumentException("Одна из сторон треугольника имеет отрицательную длинну");
        }

        if (firstSide + secondSide <= thirdSide || firstSide + thirdSide <= secondSide || secondSide + thirdSide <= firstSide) {
            throw new IllegalArgumentException("Cумма двух любых сторон должна быть не меньше третьей стороны");
        }
    }

    public static void printTriangleArea(Triangle t){
        String text = String.format("Площадь треугольника со сторонами %f, %f, %f = %f", t.firstSide, t.secondSide, t.thirdSide, t.calculateTriangleArea());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle t){
        String text = String.format("Периметер треугольника со сторонами %f, %f, %f = %f", t.firstSide, t.secondSide, t.thirdSide, t.calculatePerimeter());
        System.out.println(text);
    }

    public float calculateTriangleArea(){
        float poluperimeter = (firstSide + secondSide + thirdSide) /2;
        float triangleArea = (float) Math.sqrt(poluperimeter*(poluperimeter-firstSide)*(poluperimeter-secondSide)*(poluperimeter-thirdSide));
        return triangleArea;
    }

    public float calculatePerimeter(){
        float perimeter = firstSide + secondSide + thirdSide;
        return perimeter;
    }
}
