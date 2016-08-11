import java.io.PrintStream;

public class QuitCommand implements Command {
    @Override
    public void run() {
        // empty on purpose
        System.out.println("Quitting Biblioteca... Thank you for visiting!");
    }

    @Override
    public String returnOptionName() {
        return "Quit";
    }
}
