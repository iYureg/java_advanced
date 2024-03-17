package gb.junior.webinar_2_reflection.homework.tests;

import gb.junior.webinar_2_reflection.homework.tests.annotations.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestRunner {
    public static void run(Class<?> testClass) {

        final Object testObj = initTestObj(testClass);

        List<Method> bfe = Arrays.stream(testClass.getDeclaredMethods())
                .filter(method -> method.getAnnotation(BeforeEach.class) != null)
                .toList();

        List<Method> afe = Arrays.stream(testClass.getDeclaredMethods())
                .filter(method -> method.getAnnotation(AfterEach.class) != null)
                .toList();


        Arrays.stream(testClass.getDeclaredMethods())
                .filter(method -> method.getAnnotation(BeforeAll.class) != null)
                .forEach(method -> {
                    try {
                        String message = method.getAnnotation(BeforeAll.class).property();
                        method.setAccessible(true);
                        method.invoke(testObj, message);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });


        for (Method testMethod : testClass.getDeclaredMethods()) {


            if (testMethod.getAnnotation(Test.class) != null) {

                try {
                    for (Method method : bfe) {
                        try {
                            method.invoke(testObj);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    testMethod.invoke(testObj);

                    for (Method method : afe) {
                        try {
                            method.invoke(testObj);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }

                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }


        }


        Arrays.stream(testClass.getDeclaredMethods())
                .filter(method -> method.getAnnotation(AfterAll.class) != null)
                .forEach(method -> {
                    try {
                        String message = method.getAnnotation(AfterAll.class).property();
                        method.setAccessible(true);
                        method.invoke(testObj, message);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });

    }

    private static Object initTestObj(Class<?> testClass) {
        try {
            Constructor<?> noArgsConstructor = testClass.getConstructor();
            return noArgsConstructor.newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Нет конструктора по умолчанию");
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось создать объект тест класса");
        }

    }
}
