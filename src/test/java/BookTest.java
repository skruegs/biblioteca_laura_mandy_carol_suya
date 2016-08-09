import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {
    @Test
    public void shouldPrintTitleWhenPrinting() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("title", printStream);
        book.display();
        verify(printStream).println("title");
    }


}