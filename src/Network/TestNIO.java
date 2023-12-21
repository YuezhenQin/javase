package Network;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class TestNIO {
    //使用NIO向本地文件中写数据
    @Test
    public void write() throws Exception {
        //1.创建输出流
        FileOutputStream fos = new FileOutputStream("test.txt");
        //2.取得一个通道
        FileChannel channel = fos.getChannel();
        //3.调用allocate()分配一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4.调用put()将内容放入缓冲区
        String str = "Hello NIO.";
        buffer.put(str.getBytes());
        //5.翻转缓冲区*
        buffer.flip();
        //6.调用write()将缓冲区写入通道中
        channel.write(buffer);
        //7.关闭输出流
        fos.close();
    }
    //使用NIO从本地文件中读数据
    @Test
    public void read() throws Exception {
        File file = new File("test.txt");
        int bytes = (int) file.length();
        //1.创建输入流
        FileInputStream fis = new FileInputStream(file);
        //2.从流中取得一个通道
        FileChannel channel = fis.getChannel();
        //3.调用allocate()分配一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(bytes);
        //4.
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        System.out.println(Arrays.toString(buffer.array()));
        //5.关闭输入流
        fis.close();
    }

    //使用NIO实现文件复制
    @Test
    public void copy() throws IOException {
        //1.创建输入流和输出流
        FileInputStream fis = new FileInputStream("test.txt");
        FileOutputStream fos = new FileOutputStream("test_copied.txt");
        //2.从各个流中取得通道
        FileChannel srcChannel = fis.getChannel();
        FileChannel destChannel = fos.getChannel();
        //3.调用transferFrom() 从src复制到dest
        destChannel.transferFrom(srcChannel, 0, srcChannel.size());
        //4.关闭
        fis.close();
        fos.close();
    }

    //使用NIO

}
