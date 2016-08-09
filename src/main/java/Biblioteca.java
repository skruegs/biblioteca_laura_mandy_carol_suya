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

        //   for (Book book: bookList) book.display();
        if (bookList.size() == 1) bookList.get(0).display();
        else if (bookList.size() == 2) {
            bookList.get(0).display();
            bookList.get(1).display();
        }
    }
}
