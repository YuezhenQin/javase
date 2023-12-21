package JCL;

import java.util.*;

//V put(K,V)

//V remove(K)
//void clear()

//V get(K)

//boolean containsKey(K)
//boolean containsValue(V)
//boolean isEmpty()

//K keySet()
//V values()

//HashMap底层是HashTable
//TreeMap底层是红黑树

public class MapTest {
    //Frequency
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map);
        for (String str: args) {
            Integer freq = map.get(str);
            map.put(str, freq==null? 1: freq + 1);
        }
        System.out.print(map.size() + " distinct words:");
        System.out.println(map);
        System.out.println("------------");

        //准备一个Map集合
        Map<Integer, Integer> dict = new TreeMap<>();
        for (int i = 0; i < 5; i ++) {
            dict.put(i, i);
        }
        System.out.println(dict);
        //方式一: keySet()
        for (Integer key: dict.keySet()) {
            System.out.println("K: " + key + " " + "V:" + dict.get(key));
        }
        System.out.println("------------");

        //方式二: entrySet() (推荐使用)
        for (Map.Entry<Integer, Integer> entry: dict.entrySet()) {
            System.out.println("K: " + entry.getKey() + " " + "V:" + entry.getValue());
        }
        System.out.println("------------");

        //方式三: Lambda表达式 (推荐使用)
        dict.forEach((k, v) -> System.out.println("K: " + k + " " + "V:" + v));

        Set<Integer> keys = dict.keySet();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }
        Collection<Integer> values = dict.values();
        for (Integer value : values) {
            System.out.print(value + " ");
        }
    }
}
