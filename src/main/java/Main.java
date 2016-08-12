import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        List<Book> bookList = createListOfBooks(printStream);

        Map<String,Command> commandMap = new LinkedHashMap<>();
        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<Book>(), printStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        generateMenuOptions(biblioteca, commandMap, reader, printStream);
        Menu menu = new Menu(System.out, reader, commandMap);
        menu.start();
    }

    private static List<Book> createListOfBooks(PrintStream printStream) {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Head First Java", "Laura", "1993", printStream);
        Book book2 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "2000", printStream);
        bookList.add(book1);
        bookList.add(book2);
        return bookList;
    }

    private static void generateMenuOptions(Biblioteca biblioteca, Map<String, Command> commandMap, BufferedReader reader, PrintStream printStream) {
        Command quitCommand = new QuitCommand();
        Command listBooksCommand = new ListBooksCommand(biblioteca);
        Command checkOutCommand = new CheckOutCommand(biblioteca, reader, printStream);
        Command checkInCommand = new CheckInCommand(biblioteca, reader, printStream);
        commandMap.put("0", quitCommand);
        commandMap.put("1", listBooksCommand);
        commandMap.put("2", checkOutCommand);
        commandMap.put("3", checkInCommand);
    }
}
