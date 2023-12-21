package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket s;

    //合成复用原则
    public ClientHandler(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintStream ps = null;

        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));//字节流向字符流转换
            ps = new PrintStream(s.getOutputStream());
            while(true) {
                String str = br.readLine(); //阻塞在这里
                System.out.println("来自客户端的字符串:" + str);

                if ("再见".equals(str)) {
                    System.out.println("客户端已下线");
                    break;
                }

                ps.println("已收到");
                System.out.println("服务器已发送!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
