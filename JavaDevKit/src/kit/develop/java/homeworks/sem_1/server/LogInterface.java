package kit.develop.java.homeworks.sem_1.server;

public interface LogInterface <T>{
    void save(T value);
    T read();
}
