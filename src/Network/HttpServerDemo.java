package Network;

import com.sun.net.httpserver.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//src: https://hyperskill.org/learn/step/27737

//Java developers have quite a lot of different HTTP servers to choose from,
// such as Tomcat, Jetty, or Spark, but you can also set up a simple server
// using regular Java APIs from the com.sun.net.httpserver of jdk.httpserver module.
public class HttpServerDemo {
    //HttpContext: Establishes the mapping between the URI path and the HttpHandler
    //HttpHandler: Handles request
    //HttpExchange: Stores the request/response data

    public static void main(String[] args) throws IOException {
        // Set the port on the IP address
        InetAddress localAddress = InetAddress.getByName("localhost");
        // Create the server listening to the given port on the given IP address
        HttpServer server = HttpServer.create(new InetSocketAddress(localAddress, 8080), 1000); //request queue
        server.setExecutor(Executors.newFixedThreadPool(10)); // set an executor that handles requests in tasks in order to handle multiple request simultaneously
        // Create a default context
        HttpContext context = server.createContext("/home", new MyHttpHandler());

        context.setAuthenticator(new BasicAuthenticator("realm") {
            @Override
            public boolean checkCredentials(String username, String password) {
                return username.equals("admin") && password.equals("123456");
            }
        });

        // Start the server
        server.start();

        System.out.println("Server started");
    }


}

class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.printf("Accepted a %s request from %s \n", exchange.getRequestMethod(), exchange.getRemoteAddress());


//        // Response content
//        String response = "Hello world!";
//        // Response status and length (in bytes)
//        exchange.sendResponseHeaders(200, response.length());
//        // Output the response
//        try (OutputStream stream = exchange.getResponseBody()) {
//            stream.write(response.getBytes());

        if (exchange.getRequestMethod().equals("GET")) {
            handleGetRequest(exchange);
        } else if (exchange.getRequestMethod().equals("POST")) {
            handlePostRequest(exchange);
        }

            /* Other request types */

        }
    public Headers handleGetRequest(HttpExchange exchange) throws IOException {
        String response = "Hello, " + exchange.getRequestURI().toString().split("=")[1];
        exchange.sendResponseHeaders(200, response.getBytes().length);
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");

        try (OutputStream stream = exchange.getResponseBody()) {
            stream.write(response.getBytes());
        }
        return exchange.getResponseHeaders();
    }

    public Headers handlePostRequest(HttpExchange exchange) throws IOException {
        String response = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))) {
            while (reader.ready()) {
                response += reader.readLine();
            }
        }
        response = response.split(":")[1].replaceAll("[^a-zA-Z]", "");
        System.out.println("Content type: " + exchange.getRequestHeaders().get("Content-type"));

        exchange.sendResponseHeaders(200, response.length());

        try (OutputStream stream = exchange.getResponseBody()) {
            stream.write(response.getBytes());
        }
        return exchange.getResponseHeaders();
    }
}
