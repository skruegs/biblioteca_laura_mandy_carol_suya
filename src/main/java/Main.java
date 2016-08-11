import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Book> bookList = createListOfBooks();

        Map<String,Command> commandMap = new LinkedHashMap<String, Command>();
        Biblioteca biblioteca = new Biblioteca(System.out, bookList);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        generateMenuOptions(biblioteca, commandMap);
        Menu menu = new Menu(System.out, reader, biblioteca, commandMap);
        menu.start();
    }

    private static List<Book> createListOfBooks() {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("Head First Java", "Laura", "1993", System.out);
        Book book2 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "2000", System.out);
        bookList.add(book1);
        bookList.add(book2);
        return bookList;
    }

    private static void generateMenuOptions(Biblioteca biblioteca, Map<String, Command> commandMap) {
        Command quitCommand = new QuitCommand();
        Command listBooksCommand = new ListBooksCommand(biblioteca);
        commandMap.put("0", quitCommand);
        commandMap.put("1", listBooksCommand);
    }
}
