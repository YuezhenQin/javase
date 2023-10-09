package 网络;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        Socket s = null;
        BufferedReader br = null;
        PrintStream ps = null;
        try {
            //1.创建 ServerSocket 类型的对象并提供端口号
            ss = new ServerSocket(8888);
            while(true) {
                //2. 等待来自客户端的连接请求
                System.out.println("等待来自客户端的连接请求...");
                s = ss.accept(); // 阻塞在 accept()
                System.out.println("New client connected: " + s.getInetAddress().getHostAddress());
                //若有一个客户端连接成功，则启动一个新的线程为之服务
                new ClientHandler(s).start();
            }

            //3.使用输入输出流通信
//            br = new BufferedReader(new InputStreamReader(s.getInputStream()));//字节流向字符流转换
//            ps = new PrintStream(s.getOutputStream());
//            while(true) {
//                String str = br.readLine(); //阻塞在这里
//                System.out.println("来自客户端的字符串:" + str);
//
//                if ("再见".equals(str)) {
//                    System.out.println("会话结束");
//                    break;
//                }
//
//                ps.println("已收到");
//                System.out.println("服务器已发送!");
//            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (null != ps) {
                ps.close();
            }
            if (null != br) {
                br.close();
            }
            if (null != s) {
                s.close();
            }
            if (null != ss) {
                ss.close();
            }
        }
    }
}
