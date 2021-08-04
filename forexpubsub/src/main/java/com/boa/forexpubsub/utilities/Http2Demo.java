package com.boa.forexpubsub.utilities;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.boa.forexpubsub.models.Photo;
//import com.google.gson.Gson;

//synchronous call 
public class Http2Demo {
	private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    public static void main(String[] args) throws IOException {
    	HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/photos"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();

        HttpResponse<String> response;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			// print response headers
	        HttpHeaders headers = response.headers();
	        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

	        // print status code
	       // System.out.println(response.statusCode());

	        // print response body
	   //     Gson gson=new Gson();
	      System.out.println(response.body());
	     
	      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        

       
    }
}