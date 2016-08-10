import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Menu {

    private PrintStream printStream;
    private BufferedReader reader;
    private Biblioteca biblioteca;
    private Map<String, Command> commandMap;
    private String userChoice;


    public Menu(PrintStream printStream, BufferedReader reader, Biblioteca biblioteca, Map<String, Command> commandMap) {
        this.printStream = printStream;
        this.reader = reader;
        this.biblioteca = biblioteca;
        this.commandMap = commandMap;
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
//        printStream.println("2) Other Option");
    }

    public void processesUserOption() throws IOException {
        userChoice = reader.readLine();
        if(commandMap.containsKey(userChoice))
            commandMap.get(userChoice).run();
        else {
            printStream.println("Select a valid option!");
        }
    }
}
