import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckOutCommand implements Command {

    private Biblioteca biblioteca;
    private BufferedReader reader;
    private PrintStream printStream;

    public CheckOutCommand(Biblioteca biblioteca, BufferedReader reader, PrintStream printStream) {
        this.biblioteca = biblioteca;
        this.reader = reader;
        this.printStream = printStream;
    }

    @Override
    public void run() {
        printStream.println("Enter title to check out:");
        try {
            String input = reader.readLine();
            biblioteca.checkOutBook(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String returnOptionName() {
        return "Check Out Book";
    }
}
