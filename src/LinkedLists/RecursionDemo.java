package LinkedLists;

//Recursion is a problem-solving method. In code, recursion is implemented using a function that calls itself.
public class RecursionDemo {
    public static void plus(int i) {
        if (i > 3) return;

        System.out.println(i);
        plus(i + 1);
        System.out.println("End of call where i = " + i);
        return;
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        plus(1);
    }
}
