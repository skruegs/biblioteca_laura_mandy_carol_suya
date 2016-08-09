import java.io.PrintStream;
import java.util.List;

public class Biblioteca {
    PrintStream printStream;
    List<Book> bookList;

    public Biblioteca (PrintStream printStream, List<Book> bookList) {
        this.printStream = printStream;
        this.bookList = bookList;
    }

    public void start() {
        printStream.println("Welcome");
        listBooks();
    }

    public void listBooks() {

        for (Book book: bookList) book.display();

    }
}
