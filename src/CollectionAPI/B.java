package CollectionAPI;

public class B extends A {
    int k;

    public B(int i, int j, int k) {
        super(i, j);
        this.k = k;
    }
    //Method Overload
    public void show(String msg) {
        System.out.println(msg + k);
    }

    //Method Override
    @Override
    public void show() {
        //invoke superclass
        super.show();
        System.out.println(" k:" + k);
    }
}
