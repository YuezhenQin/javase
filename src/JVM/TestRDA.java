package JVM;

import java.util.HashMap;

//字符串常量池
public class TestRDA {
    public static void main(String[] args) {
        //字符串常量池的数据结构为 StringTable
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Hello", 1);
        map.put("World", 2);
        //由“ ”包裹的字符串，编译阶段放入字符串常量池
        String str = "Hello";
        System.out.println("Hello.hashCode()=" + "Hello".hashCode());
        System.out.println("str.hashCode()=" + str.hashCode());
        //涉及到符号引用的字符串，作为新的对象在运行阶段放入堆内存的其他区域中
        String str1 = new String("Hello");
        System.out.println(str == str1);
    }
}
