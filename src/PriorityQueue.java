//基于堆的优先队列

public class PriorityQueue <E extends Comparable<E>> implements Queue<E> {
     private MaxHeap<E> maxHeap;
     public PriorityQueue() {
         maxHeap = new MaxHeap<>();
     }

     @Override
     public int getSize() {
         return maxHeap.getSize();
     }
     @Override
     public boolean isEmpty() {
         return maxHeap.isEmpty();
     }

    @Override
     public E getFirst() {
         return maxHeap.findMax();
     }

     @Override
     public void enqueue(E e) {
         maxHeap.add(e);
     }

     @Override
     public E dequeue() {
         return maxHeap.extractMax();
     }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.enqueue(9);
        System.out.println(pq.getFirst());
        pq.enqueue(8);
        System.out.println(pq.getFirst());
        pq.enqueue(99);
        System.out.println(pq.getFirst());
        while (!pq.isEmpty()) {
            System.out.println(pq.dequeue());
        }
    }
}
