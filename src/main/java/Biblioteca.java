import java.io.PrintStream;

public class Biblioteca {
    PrintStream printStream;

    public Biblioteca (PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome");
    }
}
