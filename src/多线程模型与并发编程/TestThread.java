package 多线程模型与并发编程;

public class TestThread {
    private int a = 1;
    private int b = 1;

    public void set() {
        a = 99;
        b = 99;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    //上面的代码，当线程1执行set()的时候，线程2访问getA()和getB会得到什么样的结果？
    //A.a=1,b=1    //都未改变
    //B.a=99,b=99  //都已改变
    //C.a=99,b=1   //a改变了，b未改变
    //D.a=1,b=99   //a未改变，b改变了

    //上面的A,B,C都好理解，但是D可能会出乎一些人的意料

    //这是一个多线程之间内存可见性 (visibility) 顺序不一致的问题
    //1.JVM 的 reordering
    //2.从线程工作内存(栈)写回内存(堆)的顺序无法保证

    //happen-before规则

    //Reference: https://www.slideshare.net/hongjiang/concurrent-hashmap
}
