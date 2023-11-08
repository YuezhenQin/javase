package JVM;
//反射机制是什么？反射机制(运行时类型识别)是用来动态地创建对象的机制。

//如何取得Class类型的对象？
//1. .class
//2. getClass()
//3. Class.forName(包名.类名)
//4. 类加载器

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //.class
        Class c1 = Integer.class;
        System.out.println(c1.toString()); //class java.lang.Integer
        Class c2 = void.class;
        System.out.println(c2.toString()); //void
        System.out.println("-----------");
        //.getClass()
        Double d = 0.0;
        c1 = d.getClass();
        System.out.println(c1.toString()); //class java.lang.Double
        //Class.forName(包名.类名)
        c1 = Class.forName("java.lang.String");
        System.out.println(c1.toString());
        //类加载器
        ClassLoader loader = TestClass.class.getClassLoader();
        System.out.println("classloader=" + loader);


        c1 = Class.forName("Person");
        System.out.println(c1.newInstance());

        //运行阶段类型识别
        System.out.println("请输入:");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        c1 = Class.forName(str);
        System.out.println(c1.newInstance());
        sc.close();


    }
}
