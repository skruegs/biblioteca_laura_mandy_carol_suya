import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    @Test
    public void shouldPrintWelcomeWhenStart() {
        PrintStream printStream = mock(PrintStream.class);
        Biblioteca biblioteca = new Biblioteca(printStream);
        biblioteca.start();
        verify(printStream).println("Welcome");
    }

    @Test
    public void shouldPrintHarryPotterWhenListBooksIsCalled(){
        PrintStream printStream = mock(PrintStream.class);
        Biblioteca biblioteca = new Biblioteca(printStream);
        biblioteca.listBooks();
        verify(printStream).println(contains("Harry Potter"));
    }

}
