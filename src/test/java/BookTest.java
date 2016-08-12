import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    private Book book;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        book = new Book("title", "author", "year", printStream);
    }

    @Test
    public void shouldPrintTitleWhenPrinting() throws Exception {
        book.display();
        verify(printStream).println(contains("title"));
    }


    @Test
    public void shouldPrintTitleAuthorYearWhenDisplaying(){
        book.display();
        verify(printStream).println(contains("title"));
        verify(printStream).println(contains("author"));
        verify(printStream).println(contains("year"));
    }

    @Test
    public void shouldReturnTrueWhenIsThisMyTitleIsCalledWithCorrectTitle() {
        assertTrue(book.isThisMyTitle("title"));
    }

    @Test
    public void shouldReturnFalseWhenIsThisMyTitleIsCalledWithIncorrectTitle() {
        assertFalse(book.isThisMyTitle("not my title"));
    }
}