package kit.develop.java.seminar_2.canvas.circles.exceptions;

public class BallsOverflowException extends RuntimeException{
    public BallsOverflowException(){
        super("Невозможно создать более 15 шаров");
    }
}
