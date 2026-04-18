package test.me;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

public class ExampleTest {

    @BeforeAll
   static void before() {
        System.out.println("BeforeAll");
    }

    @Test
    void firstTest() {
        System.out.println("Test");
    }

    @AfterAll
    static void after() {
        System.out.println("AfterAll");
    }

}
