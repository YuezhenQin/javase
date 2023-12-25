package CollectionAPI;

public class HelloWorld {
    //Code with me

    public static void main(String[] args){
        A a = new A(0, 1);
        B b = new B(10,11,12);
        b.show();
        System.out.println(b.inherited);
        b.show("After method override, now it is: ");
    }
}
