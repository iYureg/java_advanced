package gb.junior.Lesson_1_lambda_and_stream_API.bestpractic;


import lombok.Data;


public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d лет.", name, age);
    }
}
