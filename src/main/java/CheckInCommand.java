import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckInCommand implements Command {
    private Biblioteca biblioteca;
    private final BufferedReader reader;
    private final PrintStream printStream;

    public CheckInCommand(Biblioteca biblioteca, BufferedReader reader, PrintStream printStream) {

        this.biblioteca = biblioteca;
        this.reader = reader;
        this.printStream = printStream;
    }

    @Override
    public void run() {
        printStream.println("Enter title to check in:");
        try {
            String input = reader.readLine();
            biblioteca.checkInBook(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String returnOptionName() {
        return "Check In Book";
    }
}
