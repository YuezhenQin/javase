package Design_Patterns.SingletonPattern;

//final: clone()
public final class IntegerSingleton implements Resource<Integer> {

    private static final IntegerSingleton obj = new IntegerSingleton();
    private Integer value = 0;
    private IntegerSingleton() { //private: constructor
        System.out.println("IntegerSingleton()");
    }

    public static IntegerSingleton instance() {
        return obj;
    }

    @Override
    public synchronized Integer get() {
        return value;
    }

    @Override
    public synchronized void set(Integer value) {
        this.value = value;
    }
}
