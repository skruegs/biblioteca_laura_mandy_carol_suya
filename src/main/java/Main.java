import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> bookList = new ArrayList<String>();
        Biblioteca biblioteca = new Biblioteca(System.out, bookList);
        biblioteca.start();

    }
}
