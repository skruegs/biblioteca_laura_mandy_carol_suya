import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<String> bookList;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<String>();
        bookList.add("Harry Potter");
        bookList.add("The Grimm");
        biblioteca = new Biblioteca(printStream, bookList);
    }

    @Test
    public void shouldPrintWelcomeWhenStart() {
        biblioteca.start();
        verify(printStream).println("Welcome");
    }

    @Test
    public void shouldPrintHarryPotterWhenListBooksIsCalled(){
        biblioteca.listBooks();
        verify(printStream).println(contains("Harry Potter"));
    }

    @Test
    public void shouldPrintTheGrimmWHenListBooksIsCalled(){
        biblioteca.listBooks();
        verify(printStream).println(contains("The Grimm"));
    }

}
