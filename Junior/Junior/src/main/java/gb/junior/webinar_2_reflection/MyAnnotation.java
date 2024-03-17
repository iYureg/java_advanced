package gb.junior.webinar_2_reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    // int...boolean.. - all primitive
    // String
    // Class  (SomeClass.class)
    // any enum
    // all of that upper arrays
    String[] myParam() default "defaultValue";
}
