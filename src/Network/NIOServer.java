package Network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
    public static void main(String[] args) throws Exception {
        //1.ServerSocketChannel.open() 开启一个通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.Selector.open() 开启一个 Selector 选择器
        Selector selector = Selector.open();
        //3.通道绑定端口号
        System.out.println("服务端启动...");
        ssChannel.bind(new InetSocketAddress(9999));
        //4.通道配置非阻塞方式
        ssChannel.configureBlocking(false);
        //5.通道调用register()注册选择器
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.无限循环，持续地监听连接、读、写
        while (true) {
            //6.1
            if (selector.select(2000) == 0) {
                System.out.println("Server: do something else");
                continue;
            }
            //6.2 SelectionKey 是 Selector 与 Channel 之间的桥梁。
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                //连接事件
                if (key.isAcceptable()) {
                    SocketChannel sc = ssChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    System.out.println(sc.getRemoteAddress().toString().substring(1) + " 上线了.");
                }
                //读事件
                if (key.isReadable()) {

                }
                //写事件
                if (key.isWritable()) {}

                iter.remove();
            }
        }
    }
}
