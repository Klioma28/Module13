package Module13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task1 {

    public void CreateObject() throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users";

        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("user.json"));
        User user = gson.fromJson(reader, User.class);
        reader.close();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(user.toString()))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.body() = " + response.body());
    }

    public void UpdateObject(int id) throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users/"+id;

        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("user.json"));
        User user = gson.fromJson(reader, User.class);
        reader.close();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(user.toString()))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.body() = " + response.body());
    }

    public void DeleteObject(int id) throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users/"+id;
        Gson gson = new Gson();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.body() = " + response.body());
    }

    public void AllUsers() throws IOException {
        String url = "https://jsonplaceholder.typicode.com/users";
        String response = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken
                .getParameterized(List.class, User.class)
                .getType();

        List<User> users = new Gson().fromJson(response, type);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        System.out.println("Users = " + json);
    }
    public void InfoByID(int id) throws IOException {
        String url = "https://jsonplaceholder.typicode.com/users/"+id;
        String response = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        User user = new Gson().fromJson(response, User.class);
        System.out.println("User"+id+" = " + user);
    }

    public void InfoByName(String name) throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users?username="+name;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.body() = " + response.body());
    }
}
