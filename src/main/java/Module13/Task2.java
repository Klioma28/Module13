package Module13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    public void ShowComments(int id) throws IOException {
        String url = "https://jsonplaceholder.typicode.com/users/"+id+"/posts";
        String response = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken
                .getParameterized(List.class, Post.class)
                .getType();

        List<Post> posts = new Gson().fromJson(response, type);
        Post lastPost = posts.stream().max(Comparator.comparing(Post::getId)).get();
        url = "https://jsonplaceholder.typicode.com/posts/"+lastPost.getId()+"/comments";

        response = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        type = TypeToken
                .getParameterized(List.class, Comment.class)
                .getType();

        List<Comment> comments = new Gson().fromJson(response, type);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(comments);

        File file = new File("user-"+id+"-post-"+lastPost.getId()+"-comments.json");
        try (FileWriter writer = new FileWriter(file))
        {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Comments = " + json);
    }
}
