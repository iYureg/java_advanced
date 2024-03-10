package gb.junior.Lesson_1_lambda_and_stream_API.functional_interface;

@FunctionalInterface
public interface PlainInterface1 {

    // интерфейс с одним методом является функциональным
    // можно реализовать с помошью лямбда выражения
    String action(int x, int y);
}
