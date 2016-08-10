import java.io.PrintStream;

public class ListBooksCommand implements Command {

    Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void run() {
        biblioteca.listBooks();
    }

}
