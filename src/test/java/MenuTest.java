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
    Command quitCommand;
    Command checkOutCommand;
    private Command checkInCommand;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        commandMap = new HashMap<>();
        listBooksCommand = mock(ListBooksCommand.class);
        quitCommand = mock(QuitCommand.class);
        checkOutCommand = mock(CheckOutCommand.class);
        checkInCommand = mock(CheckInCommand.class);
        commandMap.put("0", quitCommand);
        commandMap.put("1", listBooksCommand);
        commandMap.put("2", checkOutCommand);
        commandMap.put("3", checkInCommand);
        menu = new Menu(printStream, reader, commandMap);
    }

    @Test
    public void shouldPrintWelcomeWhenStart() throws IOException {
        when(reader.readLine()).thenReturn("1", "0");
        menu.start();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldDisplayListOfOptionsWithOneOptionListBooks() {
        menu.printOptionsList();
        verify(printStream).println("Please enter the # of the option you would like to select:");
        verify(listBooksCommand).returnOptionName();
    }

    @Test
    public void shouldCallListBooksWhenOptionOneChosen() throws IOException {
        when(reader.readLine()).thenReturn("1");
        menu.processUserOption();
        verify(listBooksCommand).run();
    }

    @Test
    public void shouldGiveErrorMessageWhenInvalidOptionEntered() throws Exception{
        when(reader.readLine()).thenReturn("&", "1");
        menu.processUserOption();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldCallQuitWhenOptionZeroChosen() throws IOException {
        when(reader.readLine()).thenReturn("0");
        menu.processUserOption();
        verify(quitCommand).run();
    }

    @Test
    public void shouldKeepAskingWhenGivenInvalidInputUntilGivenValidInput() throws Exception {
        when(reader.readLine()).thenReturn("$", "what", "1");
        menu.processUserOption();
        verify(listBooksCommand).run();
    }

    @Test
    public void shouldCallCheckOutBookWhenOptionTwoIsChosen() throws Exception {
        when(reader.readLine()).thenReturn("2", "0");
        menu.processUserOption();
        verify(checkOutCommand).run();
    }

    @Test
    public void shouldCallCheckInBookWhenOptionThreeIsChosen() throws Exception {
        when(reader.readLine()).thenReturn("3", "0");
        menu.processUserOption();
        verify(checkInCommand).run();
    }
}