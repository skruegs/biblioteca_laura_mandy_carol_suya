public class CheckOutCommand implements Command {

    private Biblioteca biblioteca;

    public CheckOutCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        System.out.print("in Checkout");
    }

    @Override
    public String returnOptionName() {
        return "Check Out Book";
    }
}
