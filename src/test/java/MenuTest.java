import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    PrintStream printStream;
    Menu menu;
    BufferedReader reader;
    Biblioteca biblioteca;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
    }

    @Test
    public void shouldDisplayListOfOptionsWithOneOptionListBooks() {
        menu = new Menu(printStream, reader, biblioteca);
        menu.printOptionsList();
        verify(printStream).println("Please select one of the following options:");
        verify(printStream).println("1) List of Books");
    }

    @Test
    public void shouldPrintListOfBooksWhenOptionOneChosen() {
        menu = new Menu(printStream, reader, biblioteca);
        menu.processesUserOption(1);
        verify(biblioteca).listBooks();
    }
}