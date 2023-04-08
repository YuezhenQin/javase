public class Main {
    public static void main(String[] args) {
        /* Array Test */
//        Array arr = new Array(20);
        Array<Integer> arr = new Array(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(10, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(1);
        arr.remove(1);
        System.out.println(arr);
    }
}

