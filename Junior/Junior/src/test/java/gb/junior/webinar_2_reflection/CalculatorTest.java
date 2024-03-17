package gb.junior.webinar_2_reflection;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("afterEach");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("afterAll");
    }

    @Test
    void testSum1(){
        Calculator calculator = new Calculator();
        int actual = calculator.sum(2, 5);
        Assertions.assertEquals(7, actual);
        System.out.println("test1");
    }

    @Test
    void testSum2(){
        Calculator calculator = new Calculator();
        int actual = calculator.sum(0, -3);
        Assertions.assertEquals(-3, actual);
        System.out.println("test2");
    }

}