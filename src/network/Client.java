package network;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //1.新建 Socket 类型的对象并提供ip地址和端口号
        Socket s = null;
        PrintStream ps = null;
        Scanner sc = null;
        BufferedReader br = null;
        try {
            s = new Socket("127.0.0.1", 8888);
            System.out.println("客户端已连接到服务器。");
            sc = new Scanner(System.in);
            ps = new PrintStream(s.getOutputStream());
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            while (true) {
                //2.使用输入输出流通信（用输出流发，用输入流收）
                //客户端向服务器发送字符串内容"hi"

                //客户端发送的内容由键盘输入
                System.out.print("$");
                String str = sc.next();

//            Thread.sleep(10000);
//            ps.println("hi");
                ps.println(str);
                System.out.println("客户端已发送。");


                if ("再见".equalsIgnoreCase(str)) {
                    System.out.println("会话结束");
                    break;
                }
                String message = br.readLine();
                System.out.println("来自服务器的字符串:" + message);

            }
        } catch (IOException /*| InterruptedException*/ e) {
            throw new RuntimeException(e);
        } finally {
            //3.关闭并释放资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (null != sc) {
                sc.close();
            }
            if (null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (null != ps) {
                ps.close();
            }
        }
    }
}
