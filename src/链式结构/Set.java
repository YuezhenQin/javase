package 链式结构;
/*
* Set
*              LLSet   BSTSet        HashSet
* add()        O(n)    O(h)=O(logn)
* contains()   O(n)    O(h)=O(logn)
* remove()     O(n)    O(h)=O(logn)
* */

public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}

