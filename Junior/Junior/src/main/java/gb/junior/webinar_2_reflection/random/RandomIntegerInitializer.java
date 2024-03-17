package gb.junior.webinar_2_reflection.random;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIntegerInitializer {

    private final static Random random = new Random();
    public static void init(Object obj){
        Class<?> objClass = obj.getClass();

        for (Field field : objClass.getDeclaredFields()) {
            RandomInteger anno = field.getAnnotation(RandomInteger.class);
            if(anno != null){
                if(int.class.equals(field.getType())){
                    int randomValue = random.nextInt(anno.min(), anno.max());
                    try {
                        field.setAccessible(true);
                        field.set(obj, randomValue);
                    } catch (IllegalAccessException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
