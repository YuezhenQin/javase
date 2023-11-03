package 链式结构;

import 链式结构.树结构.BSTMap;
import 链式结构.树结构.BSTSet;
import 链式结构.树结构.FileOperation;
import 链式结构.树结构.Set;

import java.util.ArrayList;

public class Main {
    public static String pathToFileName(String path) {
        int index = path.lastIndexOf("\\");
        return path.substring(index + 1);
    }
    private static void testSet(Set<String> set, String path) {
        long startTime = System.nanoTime();

        String fileName = pathToFileName(path);
        System.out.println(fileName);

        ArrayList<String> words = new ArrayList<>();

        FileOperation.readFile(path, words);
        System.out.print("total: " + words.size() );
        for (String word: words) {
            set.add(word);
        }
        System.out.println(" total different: " + set.getSize());

        long endTime = System.nanoTime();

        double time =  (endTime - startTime) / 1000000000.0;
        System.out.println(set.getClass().getSimpleName() + ": " + time);
    }

    public static void testMap(Map<String, Integer> map, String path) {

        long startTime = System.nanoTime();

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(path, words);
        System.out.print("total: " + words.size() );

        for (String word: words) {
            if (map.contains(word)) {
                //更新
                map.set(word, map.get(word) + 1); //
            } else {
                //插入
                map.add(word, 1);
            }
        }

        System.out.println(" total different: " + map.getSize());
        System.out.println("Frequency of PRIDE: " + map.get("pride"));
        System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));


        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println(map.getClass().getSimpleName() + ":" + time);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(1, 999);
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println();

        //LLSet, BSTSet
        String path1 = "C:\\Users\\Yuezh\\IdeaProjects\\javase\\src\\链式结构\\树结构\\pride-and-prejudice.txt";
        String path2 = "C:\\Users\\Yuezh\\IdeaProjects\\javase\\src\\链式结构\\树结构\\a-tale-of-two-cities.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        testSet(bstSet, path1);
        testSet(bstSet, path2);

        System.out.println();

        LLSet<String> llSet = new LLSet<>();
        testSet(llSet, path1);
        testSet(llSet, path2);

        System.out.println();
        //LLMap, BSTMap
        LLMap<String, Integer> llMap = new LLMap<>();
        testMap(llMap, path1);

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        testMap(bstMap, path1);

    }
}
