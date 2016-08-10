import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {
    @Test
    public void shouldPrintTitleWhenPrinting() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("title", "author", "year",printStream);
        book.display();
        verify(printStream).println(contains("title"));
    }

    @Test
    public void shouldPrintTitleAuthorYearWhenDisplaying(){
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("title","author","year",printStream);
        book.display();
        verify(printStream).println(contains("title"));
        verify(printStream).println(contains("author"));
        verify(printStream).println(contains("year"));
    }


}