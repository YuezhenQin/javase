package JDK.Java8_2014;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File[] files = new File(".").listFiles(File::isHidden);
        for (File file: files) {
            System.out.println(file.getName());
        }
    }
}
