package 链式结构;

import 链式结构.树结构.BSTSet;
import 链式结构.树结构.FileOperation;
import 链式结构.树结构.Set;

import java.util.ArrayList;

public class Main {
    private static double testSet(Set<String> set, String path) {
        long startTime = System.nanoTime();

        int index = path.lastIndexOf("\\");
        String fileName = path.substring(index + 1);
        System.out.println(fileName);

        ArrayList<String> words = new ArrayList<>();

        FileOperation.readFile(path, words);
        System.out.println("total: " + words.size());
        for (String word: words) {
            set.add(word);
        }
        System.out.println("total different: " + set.getSize());

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
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

        //LLSet, BSTSet
        String path1 = "C:\\Users\\Yuezh\\IdeaProjects\\javase\\src\\动态数据结构\\树结构\\pride-and-prejudice.txt";
        String path2 = "C:\\Users\\Yuezh\\IdeaProjects\\javase\\src\\动态数据结构\\树结构\\a-tale-of-two-cities.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, path1);
        System.out.println(time1);

        System.out.println();

        LLSet<String> llSet = new LLSet<>();
        double time2 = testSet(llSet, path1);
        System.out.println(time2);


    }
}
