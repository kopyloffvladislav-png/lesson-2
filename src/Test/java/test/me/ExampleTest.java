package test.me;

import org.junit.jupiter.api.*;

public class ExampleTest {

    @BeforeAll
   static void before() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
    }

    @Test
    void firstTest() {
        System.out.println("Test1");
    }

    @Test
    void secondTest() {
        System.out.println("Test2");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }

    @AfterAll
    static void after() {
        System.out.println("AfterAll");
    }

}
