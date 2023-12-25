package CollectionAPI;
import 排序.Person;

//1.hashCode(k1)
//2.(hashCode(k1) & 0x7fffffff) % M
//3.HashSet 就是一个 TreeSet 数组；HashMap 就是一个 TreeMap 数组
//4.一个位置对应一个链表，若哈希冲突达到一定程度，则一个位置对应一颗红黑树。
public class HashTest {
    public static void main(String[] args) {
        int a = -1;
        System.out.println(((Integer)a).hashCode());
        double b = 1.0;
        System.out.println(((Double)b).hashCode());
        String str = "hashCode";
        System.out.println(str.hashCode());
        Person p1 = new Person("T", 0);
        Person p2 = new Person("t", 0);
        Person p3 = new Person("tt", 0);

        System.out.println(p1.hashCode()); //1160
        System.out.println(p2.hashCode()); //1160
        System.out.println(p3.hashCode()); //37120
    }
}
