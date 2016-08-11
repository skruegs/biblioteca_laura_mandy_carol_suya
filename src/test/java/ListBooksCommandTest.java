import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksCommandTest {

    private Biblioteca biblioteca;
    private ListBooksCommand listBooksC;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        listBooksC = new ListBooksCommand(biblioteca);
    }

    @Test
    public void shouldPrintBooksWhenRunIsCalled() throws Exception {
        listBooksC.run();
        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldPrintListBooksWhenReturnOptionNameCalled() throws Exception {
        assertThat(listBooksC.returnOptionName(), is("List Books"));
    }
}