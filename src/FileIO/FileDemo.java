package FileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//jdk11 java.nio.file.Files 读写文件更简单
public class FileDemo {
    public static void main(String[] args) throws IOException {
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "测试字符串");
        System.out.println(path);
        String str = Files.readString(path);
        System.out.println(str);
    }
}
