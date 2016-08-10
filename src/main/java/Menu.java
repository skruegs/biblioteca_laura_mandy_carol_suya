import java.io.BufferedReader;
import java.io.PrintStream;

public class Menu {

    PrintStream printStream;
    private final BufferedReader reader;
    Biblioteca biblioteca;

    public Menu(PrintStream printStream, BufferedReader reader, Biblioteca biblioteca) {
        this.printStream = printStream;
        this.reader = reader;
        this.biblioteca = biblioteca;
    }

    public void start() {
        printOptionsList();
        processesUserOption(1);
    }

    public void printOptionsList() {
        printStream.println("Please select one of the following options:");
        printStream.println("1) List of Books");
    }

    public void processesUserOption(int userChoice) {
        if(userChoice==1) {
            biblioteca.listBooks();
        }
    }
}
