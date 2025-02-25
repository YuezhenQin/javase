package Stacks_and_Queues;

import java.util.PriorityQueue;

//Only one public class per .java file
//Should not use public,private or protected for any of supporting classes
class ToDoItem implements Comparable<ToDoItem>{
    private char primary;
    private String item;

    public ToDoItem(String item, char primary) {
        this.item = item;
        this.primary = primary;
    }

    @Override
    public int compareTo(ToDoItem that) {
        if (primary > that.primary) return 1;
        if (primary == that.primary) return 0;
        return -1;
    }

    @Override
    public String toString() {
        return primary + ": " + item;
    }
}
class ToDoList {
    public static void main(String[] args) {
        PriorityQueue<ToDoItem> pq = new PriorityQueue<>();
        pq.add(new ToDoItem("前端", 'C'));
        pq.add(new ToDoItem("后端", 'B'));
        pq.add(new ToDoItem("测试", 'A'));
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
