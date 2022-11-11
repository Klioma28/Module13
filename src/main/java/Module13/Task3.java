package Module13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task3 {
    public void ShowToDos(int id) throws IOException {
        String url = "https://jsonplaceholder.typicode.com/users/"+id+"/todos";
        String response = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken
                .getParameterized(List.class, ToDos.class)
                .getType();

        List<ToDos> toDos = new Gson().fromJson(response, type);

        List<ToDos> open = toDos.stream().filter(Predicate.not(ToDos::getCompleted)).collect(Collectors.toList());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(open);
        System.out.println("ToDos = " + json);
    }
}
