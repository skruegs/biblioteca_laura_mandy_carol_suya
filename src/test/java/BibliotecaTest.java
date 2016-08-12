import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> bookList;
    private final Book book1 = mock(Book.class);


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<>();
        bookList.add(book1);
        biblioteca = new Biblioteca(bookList);
    }

    @Test
    public void shouldCallPrintOnceWithBookListSizeOne(){
        biblioteca.listBooks();
        verify(book1,times(1)).display();
    }

    @Test
    public void shouldCallPrintTwiceWithBookListSizeTwo(){
        bookList.add(book1);
        biblioteca.listBooks();
        verify(book1, times(2)).display();
    }

    @Test
    public void bookListShouldBeEmptyWhenOneBookIsInListAndThenGetsCheckedOut() {
        String title = "<any title>";
        when(book1.isThisMyTitle(title)).thenReturn(true);
        biblioteca.checkOutBook(title);
        assertTrue(bookList.isEmpty());
    }
}
