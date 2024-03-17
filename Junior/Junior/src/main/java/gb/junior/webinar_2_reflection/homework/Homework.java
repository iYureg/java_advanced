package gb.junior.webinar_2_reflection.homework;


import gb.junior.webinar_2_reflection.homework.tests.TestRunner;
import gb.junior.webinar_2_reflection.homework.tests.annotations.*;


public class Homework {
    public static void main(String[] args) {
        TestRunner.run(Homework.class);
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @BeforeAll(property = "before all")
    private static void beforeAll(String msg){
        System.out.println(msg);
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("before each");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each");;
    }

    @AfterAll(property = "after all")
    private static void afterAll(String msg){
        System.out.println(msg);
    }


}
