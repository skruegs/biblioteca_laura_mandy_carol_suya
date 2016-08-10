import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private PrintStream printStream;
    private BufferedReader reader;
    private Biblioteca biblioteca;
    private String userChoice;

    public Menu(PrintStream printStream, BufferedReader reader, Biblioteca biblioteca) {
        this.printStream = printStream;
        this.reader = reader;
        this.biblioteca = biblioteca;
        userChoice = "0";
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!");
        printOptionsList();
        processesUserOption();
    }

    public void printOptionsList() {
        printStream.println("Please enter the # of the option you would like to select:");
        printStream.println("1) List of Books");
    }

    public void processesUserOption() throws IOException {
        userChoice = reader.readLine();
        if(Integer.parseInt(userChoice)==1) {
            biblioteca.listBooks();
        } else {
            printStream.println("Invalid option!");
        }
    }
}
