import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("Head First Java", "Laura", "1993", System.out);
        Book book2 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "2000", System.out);
        bookList.add(book1);
        bookList.add(book2);

        Biblioteca biblioteca = new Biblioteca(System.out, bookList);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = new Menu(System.out, reader, biblioteca);

        menu.start();
    }
}
