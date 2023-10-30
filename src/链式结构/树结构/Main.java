package 链式结构.树结构;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 词汇量统计
        String path = "C:\\Users\\Yuezh\\IdeaProjects\\javase\\src\\动态数据结构\\树结构\\pride-and-prejudice.txt";
        int index = path.lastIndexOf("\\");
        String fileName = path.substring(index + 1);
        System.out.println(fileName);

        ArrayList<String> words = new ArrayList<>();

        FileOperation.readFile(path, words);
        System.out.println("total: " + words.size());
        BSTSet<String> bstSet = new BSTSet<>();
        for (String word: words) {
            bstSet.add(word);
        }
        System.out.println("total different: " + bstSet.getSize());


        path = "C:\\Users\\Yuezh\\IdeaProjects\\javase\\src\\动态数据结构\\树结构\\a-tale-of-two-cities.txt";
        index = path.lastIndexOf("\\");
        fileName = path.substring(index + 1);
        System.out.println(fileName);

        words = new ArrayList<>();

        FileOperation.readFile(path, words);
        System.out.println("total: " + words.size());
        bstSet = new BSTSet<>();
        for (String word: words) {
            bstSet.add(word);
        }
        System.out.println("total different: " + bstSet.getSize());
    }
}
