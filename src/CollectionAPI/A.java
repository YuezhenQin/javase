package CollectionAPI;

public class A {

    public int inherited;
    private int i;
    private int j;

    public A(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void show() {
        System.out.print("i:" + i + " j:" + j);
    }
}
