package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//Reading from and Writing to a URLConnection
public class URLConnectionDemo {
    public static void main(String[] args) throws IOException {
        URL oracle = new URL("https://www.oracle.com/");
        URLConnection conn = oracle.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
