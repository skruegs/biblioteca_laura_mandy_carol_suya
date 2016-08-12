import java.io.PrintStream;
import java.util.List;

public class Biblioteca {

    private List<Book> bookList;
    private PrintStream printStream;

    public Biblioteca(List<Book> bookList, PrintStream printStream) {
        this.bookList = bookList;
        this.printStream = printStream;
    }

    public void listBooks() {
        for (Book book: bookList) {
            book.display();
        }
    }

    public void checkOutBook(String title) {
        boolean bookCheckedOut = false;
        for (Book book : bookList) {
            if (book.isThisMyTitle(title)) {
                bookList.remove(book);
                printStream.println("Thank you! Enjoy the book!");
                bookCheckedOut = true;
                break;
            }
        }
        if (!bookCheckedOut) {
            printStream.println("That book is not available.");
        }
    }

    public void checkInBook(String title) {
    }
}
