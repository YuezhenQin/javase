package IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//jdk11 java.nio.file.Files 读写文件更简单
public class FileDemo {
    public static void printDirectory(File file) {

    }

    public static void main(String[] args) throws IOException {
        Path path = Files.writeString(Files.createTempFile("tmp", ".txt"), "测试字符串");
        System.out.println(path);
        String str = Files.readString(path);
        System.out.println(str);


        //复制一个文件

        //创建一个新的文件或目录
//        Files.createFile(Path.of("tmp.txt"));
//        Files.createDirectories(Path.of("tmp"));

        //当前目录内容
        Files.list(Path.of(".")).forEach(System.out::println);

        //自动得到文件变化的通知

    }
}
