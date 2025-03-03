package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea(){
        var s = new Triangle(9, 6, 8);
        float result = s.calculateTriangleArea();
        Assertions.assertEquals(23.52,result,0.01f);
    }

    @Test
    void canCalculatePerimeter(){
        var s = new Triangle(9, 6, 8);
        float result = s.calculatePerimeter();
        Assertions.assertEquals(23,result);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5, 6, 10);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {

        }
    }
    @Test
    void cannotCreateTriangleWithOneSideIsBigger() {
        try {
            new Triangle(2, 2, 5);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {

        }
    }
}
