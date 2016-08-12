import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutCommandTest {

    private Biblioteca biblioteca;
    private CheckOutCommand checkOutCommand;
    private String title;
    private BufferedReader reader;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        checkOutCommand = new CheckOutCommand(biblioteca, reader, printStream);
        title = "<any title>";
    }


    @Test
    public void shouldCallCheckOutBookWhenRun() throws Exception {
        when(reader.readLine()).thenReturn(title);
        checkOutCommand.run();
        verify(biblioteca).checkOutBook(title);
    }

    @Test
    public void shouldAcceptInputFromUserWhenRunIsCalled() throws Exception {
        checkOutCommand.run();
        verify(reader).readLine();
    }
}