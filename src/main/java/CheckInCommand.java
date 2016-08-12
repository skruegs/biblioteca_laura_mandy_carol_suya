import java.io.BufferedReader;
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
        biblioteca.checkInBook("Title");
    }

    @Override
    public String returnOptionName() {
        return "Check In Book";
    }
}
