package Design_Patterns.SingletonPattern;

public interface Resource<T> {
    T get();
    void set(T t);
}
