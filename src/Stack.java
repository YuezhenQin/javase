/*
* 栈的应用
* 1.文本编辑器的撤销操作(从栈顶压入抛出元素)
* 2.操作系统记录程序的调用过程
* 3.编译器检测括号匹配 (valid parentheses)
* */

public interface Stack<E> {
    void push(E e); //入栈
    E pop(); //出栈
    E peek(); //栈顶元素
    int getSize(); //元素数量
    boolean isEmpty(); //是否为空

}
