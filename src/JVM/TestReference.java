package JVM;

import java.lang.ref.SoftReference;

public class TestReference {
    public static void main(String[] args) {
        //强引用
        Object strongR = new Object();
        //弱引用
        SoftReference<Object> softR = new SoftReference<>(strongR);
        strongR = null;
        Object newObj = softR.get();
        System.out.println(strongR);
        System.out.println(newObj);
    }
}
