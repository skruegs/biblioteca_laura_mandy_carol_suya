import java.io.PrintStream;

public class Book {

    private String author;
    private String title;
    private String year;
    private PrintStream printStream;

    public Book( String title, String author,String year, PrintStream printStream) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.printStream = printStream;
    }

    public String formatDisplayString() {
        String formatString = String.format("%-50s%-20s%-20s",title,author,year);
        return formatString;
    }

    public void display() {
        String bookString = formatDisplayString();
        printStream.println(bookString);
    }
}
