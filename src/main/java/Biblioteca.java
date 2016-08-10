import java.io.PrintStream;
import java.util.List;

public class Biblioteca {

    private PrintStream printStream;
    private List<Book> bookList;

    public Biblioteca (PrintStream printStream, List<Book> bookList) {
        this.printStream = printStream;
        this.bookList = bookList;
    }

    public void listBooks() {
        for (Book book: bookList) book.display();

    }
}
