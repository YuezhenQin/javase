package JDK.Java11_2018;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/* java11 HTTP client: The client is located in the java.net.http package (the HttpClient class)
among some other related classes such as HttpRequest and HttpResponse.
The purpose of most classes in this package is clear from their name,
which makes programming easier and your code better. */

public class HttpClientDemo {
    public static void main(String[] args) {
        /* To start using the client we need to follow these steps:
1.Create an object of the HttpClient class to use it for further interactions; the same object can be used for multiple interactions.
2.Create a URI object that represents the address of the resource we would like to request.
3.Create an object of the HttpRequest class based on the URI object and some configuration parameters.
4.Send the request by invoking the special methods of the HttpClient.
5.Get an object of HttpResponse as a result and process it.*/
        HttpClient httpClient = HttpClient.newHttpClient();

        URI firstWebSiteAddress = URI.create("http://info.cern.ch/hypertext/WWW/TheProject.html");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(firstWebSiteAddress)
                .GET() //You can also specify POST, PUT and DELETE as your request type.
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode()); // 200 if everything is OK
            System.out.println(response.body());       // a long HTML text
        } catch (Exception e) {
            System.out.println("We cannot access the site. Please, try later.");
        }

        System.out.println("╠ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬ ═ ╬═ ╣");

        URI firstService = URI.create("https://jsonplaceholder.typicode.com/posts");
        String bookData = "{\"title\":\"The Invisible Man\", \"author\":\"H. G. Wells\"}";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(firstService)
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(bookData))
                .build();


    }
}
