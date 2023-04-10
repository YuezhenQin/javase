/*
* 栈的特性
*
*
* 栈的应用
* 1.undo 操作-文本编辑器
* 2.系统调用栈-操作系统
* 3.括号匹配 (valid parentheses)-编译器
* */

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
