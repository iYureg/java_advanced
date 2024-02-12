package kit.develop.java.seminar_3.task_1;

import java.io.DataInput;
import java.io.InputStream;

//Создать обобщенный класс с тремя параметрами (T, V, K).
//Класс содержит три переменные типа (T, V, K),
//конструктор, принимающий на вход параметры типа (T, V, K),
//методы возвращающие значения трех переменных.
//
//Создать метод, выводящий на консоль имена классов для трех переменных класса.
//Наложить ограничения на параметры типа:
//T должен реализовать интерфейс Comparable,
//V должен реализовать интерфейс DataInput и расширять класс InputStream,
//K должен расширять класс Number.
public class CommonClass<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    T comparable;
    V input;
    K num;

    CommonClass(T comparable, V input, K num){
        this.comparable = comparable;
        this.input = input;
        this.num = num;
    }

    public T getComparable(){
        return comparable;
    }

    public V getInOut(){
        return input;
    }

    public K getNumber(){
        return num;
    }
    public String getClassName(){
        return String.format("T = %s, V = %s, K = %s",
                getComparable().getClass().getSimpleName(),
                getInOut().getClass().getSimpleName(),
                getNumber().getClass().getSimpleName());
    }
}
