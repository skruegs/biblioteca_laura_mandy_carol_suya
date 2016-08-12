import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckInCommandTest {
    private Biblioteca biblioteca;
    private CheckInCommand checkInCommand;
    private String title;
    private BufferedReader reader;
    private PrintStream printStream;

    @Before
    public void setUp() {
        biblioteca = mock(Biblioteca.class);
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        checkInCommand = new CheckInCommand(biblioteca, reader, printStream);
        title = "<any title>";
    }

    @Test
    public void shouldCallCheckInBookWhenRun() throws Exception {
        when(reader.readLine()).thenReturn(title);
        checkInCommand.run();
        verify(biblioteca).checkInBook(title);
    }

    @Test
    public void shouldAcceptInputFromUserWhenRunIsCalled() throws Exception {
        checkInCommand.run();
        verify(reader).readLine();
    }
}