package Design_Pattern.SingletonPattern;

public interface Resource<T> {
    T get();
    void set(T t);
}
