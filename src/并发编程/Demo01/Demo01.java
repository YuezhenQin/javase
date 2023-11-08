package 并发编程.Demo01;
//New, Runnable, Terminated
//Blocked, Waiting, TimedWaiting
public class Demo01 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("r.run()已执行");
            }
        };
        Thread t = new Thread(r);
        t.start(); //t.start()之后发生了哪些事情

    }
}
