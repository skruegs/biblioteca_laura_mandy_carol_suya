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
        userChoice = "";
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!");
        printOptionsList();

        while(!userChoice.equals("0"))
            processesUserOption();
    }

    public void printOptionsList() {
        printStream.println("Please enter the # of the option you would like to select:");
        String optionName = "";
        for(String key: commandMap.keySet()) {
            optionName = key + ") " + commandMap.get(key).returnOptionName();
            printStream.println(optionName);
        }
    }

    public void processesUserOption() throws IOException {
        userChoice = reader.readLine();

        while(!commandMap.containsKey(userChoice)) {
            printStream.println("Select a valid option!");
            userChoice = reader.readLine();
        }
            commandMap.get(userChoice).run();
    }
}
