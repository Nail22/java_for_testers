package ru.stqa.geometry.figures;

public class Triangle {

    public float firstSide;

    public float secondSide;

    public float thirdSide;


    public Triangle(float firstSide, float secondSide, float thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
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
