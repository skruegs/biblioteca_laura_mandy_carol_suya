import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> bookList;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<Book>();
    }

    @Test
    public void shouldPrintWelcomeWhenStart() {
        biblioteca = new Biblioteca(printStream, bookList);
        biblioteca.start();
        verify(printStream).println("Welcome");
    }

    @Test
    public void shouldCallPrintOnceWithBookListSizeOne(){
        Book book1 = mock(Book.class);
        bookList.add(book1);
        biblioteca = new Biblioteca(printStream, bookList);
        biblioteca.listBooks();
        verify(book1,times(1)).display();
    }

    @Test
    public void shouldCallPrintTwiceWithBookListSizeTwo(){
        Book book1 = mock(Book.class);
        bookList.add(book1);
        bookList.add(book1);
        biblioteca = new Biblioteca(printStream, bookList);
        biblioteca.listBooks();
        verify(book1,times(2)).display();
    }


}
