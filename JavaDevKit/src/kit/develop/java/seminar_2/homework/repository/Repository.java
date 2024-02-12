package kit.develop.java.seminar_2.homework.repository;

public interface Repository<T> {
    void saveMessage(T text);
    T readText();
}
