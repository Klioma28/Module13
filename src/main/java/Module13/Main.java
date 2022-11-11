package Module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Task1 task1 = new Task1();
        System.out.println("--------------------------------------------" +
                "\nCreating object from .json file\n--------------------------------------------");
        task1.CreateObject();
        System.out.println("\n--------------------------------------------" +
                "\nUpdating object with id 3\n--------------------------------------------");
        task1.UpdateObject(3);
        System.out.println("\n--------------------------------------------" +
                "\nDeleting object with id 6\n--------------------------------------------");
        task1.DeleteObject(6);
        System.out.println("\n--------------------------------------------" +
                "\nInfo about all users\n--------------------------------------------");
        task1.AllUsers();
        System.out.println("\n--------------------------------------------" +
                "\nInfo about user with id 9\n--------------------------------------------");
        task1.InfoByID(9);
        System.out.println("\n--------------------------------------------" +
                "\nInfo about user with username Kamren\n--------------------------------------------");
        task1.InfoByName("Kamren");
        System.out.println("\n--------------------------------------------" +
                "\nComments to last post of user 4\n--------------------------------------------");
        new Task2().ShowComments(4);
        System.out.println("\n--------------------------------------------" +
                "\nAll open tasks for user with id 8\n--------------------------------------------");
        new Task3().ShowToDos(8);
    }
}
