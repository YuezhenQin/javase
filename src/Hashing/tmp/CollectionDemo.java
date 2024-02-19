package Hashing.tmp;

import 排序.Person;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        //1.准备一个接口类型的引用
        Collection c1 = new ArrayList();
        c1.add('a'); //add()
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add("test");
        c1.add(new Person("Q", 1));
        System.out.println(c1);
        System.out.println(c1.contains(1)); //contains(), Objects.equals()
        System.out.println(c1.contains(new Person("Q", 1)));
    }
}
