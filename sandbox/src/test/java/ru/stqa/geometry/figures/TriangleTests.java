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

}
