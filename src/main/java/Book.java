import java.io.PrintStream;

public class Book {

    private String title;
    private PrintStream printStream;

    public Book(String title, PrintStream printStream) {

        this.title = title;
        this.printStream = printStream;
    }

    public void display() {
        printStream.println(title);
    }
}
