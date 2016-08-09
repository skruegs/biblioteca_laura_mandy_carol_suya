import java.io.PrintStream;
import java.util.List;

public class Biblioteca {
    PrintStream printStream;
    List<String> bookList;

    public Biblioteca (PrintStream printStream, List<String> bookList) {
        this.printStream = printStream;
        this.bookList = bookList;
    }

    public void start() {
        printStream.println("Welcome");
    }

    public void listBooks() {

        for (String title: bookList)
            printStream.println(title);

    }
}
