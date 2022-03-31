package org.example.JavaEnterpriseIntensive.firstLesson.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsDigitTest {
    private final IsDigit is = new IsDigit();

    @Test
    void getCountNumbers(){
        Assertions.assertEquals(3,is.getCountNumbers("12ABOBA2"));
    }

    @Test
    void getCountNumbers1(){
        Assertions.assertEquals(4,is.getCountNumbers("126ABOBA2"));
    }
}
