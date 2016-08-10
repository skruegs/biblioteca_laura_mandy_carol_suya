import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    PrintStream printStream;
    Menu menu;
    BufferedReader reader;
    Biblioteca biblioteca;
    Map<String,Command> commandMap;
    Command listBooksCommand;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        commandMap = new HashMap<String, Command>();
        listBooksCommand = mock(ListBooksCommand.class);
        commandMap.put("1", listBooksCommand);
        menu = new Menu(printStream, reader, biblioteca, commandMap);
    }

    @Test
    public void shouldPrintWelcomeWhenStart() throws IOException {
        when(reader.readLine()).thenReturn("1");
        menu.start();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldDisplayListOfOptionsWithOneOptionListBooks() {
        menu.printOptionsList();
        verify(printStream).println("Please enter the # of the option you would like to select:");
        verify(printStream).println("1) List of Books");
    }

    @Test
    public void shouldPrintListOfBooksWhenOptionOneChosen() throws IOException {
        when(reader.readLine()).thenReturn("1");
        menu.processesUserOption();
        verify(listBooksCommand).run();
    }

    @Test
    public void shouldGiveErrorMessageWhenInvalidOptionEntered() throws Exception{
        when(reader.readLine()).thenReturn("8");
        menu.processesUserOption();
        verify(printStream).println("Select a valid option!");
    }

}