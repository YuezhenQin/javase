package JVM;

public class Main {
    public static void main(String[] args) {
        //java -XX:+PrintCommandLineFlags Main
        //java -XX:+PrintCompilation Main

        System.out.println("Hello World.");
        String mode = System.getProperty("mode");
        System.out.println(mode);
    }
}
