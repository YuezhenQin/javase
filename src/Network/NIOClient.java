package Network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        //1.调用SocketChannel.open() 开启一个通道
        SocketChannel channel = SocketChannel.open();
        //2.通道设置非阻塞模式
        channel.configureBlocking(false);
        //3.服务端的 IP地址和端口号
        InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 9999);
        //4.连接到服务端
        if (!channel.connect(addr)) {
            while (!channel.finishConnect()) {
                System.out.println("连接服务端的同时，还可以做写一些其它事情...");
            }
        }
        //5.
        String msg = "你好，世界";
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        //6.向通道写入数据
        channel.write(buffer);

        System.in.read();
    }
}
