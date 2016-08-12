import java.io.PrintStream;
import java.util.List;

public class Biblioteca {

    private List<Book> checkedInList;
    private List<Book> checkedOutList;
    private PrintStream printStream;

    public Biblioteca(List<Book> checkedInList, List<Book> checkedOutList, PrintStream printStream) {
        this.checkedInList = checkedInList;
        this.checkedOutList = checkedOutList;
        this.printStream = printStream;
    }

    public void listBooks() {
        for (Book book : checkedInList) {
            book.display();
        }
    }

    public void checkOutBook(String title) {
        boolean bookCheckedOut = false;
        for (Book book : checkedInList) {
            if (book.isThisMyTitle(title)) {
                checkedInList.remove(book);
                checkedOutList.add(book);
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
        boolean bookCheckedIn = false;
        for (Book book : checkedOutList) {
            if (book.isThisMyTitle(title)) {
                checkedOutList.remove(book);
                checkedInList.add(book);
                printStream.println("Thank you for returning the book.");
                bookCheckedIn = true;
                break;
            }
        }
        if (!bookCheckedIn) {
            printStream.println("That is not a valid book to return.");
        }
    }
}
