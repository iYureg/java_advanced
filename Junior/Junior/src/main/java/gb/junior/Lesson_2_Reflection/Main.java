package gb.junior.Lesson_2_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            Class<?> car = Class.forName("gb.junior.Lesson_2_Reflection.Car");
            Constructor<?>[] constructors = car.getConstructors();
            System.out.println(car);
            System.out.println(Arrays.toString(constructors));

            Object gaz = constructors[0].newInstance("ГАЗ");
            System.out.println(gaz);

            Field[] fields = gaz.getClass().getFields();
            int tmp = fields[fields.length - 1].getInt(gaz);
            fields[fields.length - 1].setInt(gaz, tmp * 2);

            System.out.println(gaz);

            Method[] methods = gaz.getClass().getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
