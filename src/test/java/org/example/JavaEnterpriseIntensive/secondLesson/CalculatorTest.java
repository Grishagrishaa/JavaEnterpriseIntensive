package org.example.JavaEnterpriseIntensive.secondLesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Test
    void addition(){
        Assertions.assertEquals(2, calc.addiction(1,1));
    }

    @Test
    void addition1(){
        Assertions.assertEquals(44, calc.addiction(43,1));
    }

    @Test
    void addition2(){
        Assertions.assertEquals(2 + 3, calc.addiction(2,3));
    }

}
