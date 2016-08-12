public class ListBooksCommand implements Command {

    Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        biblioteca.listBooks();
    }

    @Override
    public String returnOptionName() {
        return ("List Books");
    }

}
