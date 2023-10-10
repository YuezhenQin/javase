package 动态数据结构;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
//            System.out.println(linkedList);
        }
        linkedList.add(1, 999);
        System.out.println(linkedList);
    }
}
