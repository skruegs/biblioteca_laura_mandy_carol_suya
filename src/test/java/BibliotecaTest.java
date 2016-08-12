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
    private List<Book> checkedInList;
    private final Book book1 = mock(Book.class);
    private String title;
    private List<Book> checkedOutList;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        checkedInList = new ArrayList<>();
        checkedInList.add(book1);
        checkedOutList = new ArrayList<>();
        biblioteca = new Biblioteca(checkedInList, checkedOutList, printStream);
        title = "<any title>";
    }

    @Test
    public void shouldCallPrintOnceWithBookListSizeOne(){
        biblioteca.listBooks();
        verify(book1,times(1)).display();
    }

    @Test
    public void shouldCallPrintTwiceWithBookListSizeTwo(){
        checkedInList.add(book1);
        biblioteca.listBooks();
        verify(book1, times(2)).display();
    }

    @Test
    public void bookListShouldBeEmptyWhenOneBookIsInListAndThenGetsCheckedOut() {
        when(book1.isThisMyTitle(title)).thenReturn(true);
        biblioteca.checkOutBook(title);
        assertTrue(checkedInList.isEmpty());
    }

    @Test
    public void shouldPrintSuccessfulCheckedOutMessageWhenBookIsCheckedOut() {
        when(book1.isThisMyTitle(title)).thenReturn(true);
        biblioteca.checkOutBook(title);
        verify(printStream).println("Thank you! Enjoy the book!");
    }

    @Test
    public void shouldPrintFailedCheckOutMessageWhenBookIsNotAvail() throws Exception {
        when(book1.isThisMyTitle(title)).thenReturn(false);
        biblioteca.checkOutBook(title);
        verify(printStream).println("That book is not available.");
    }


    @Test
    public void shouldCallPrintTwiceWithOneCheckedInBookAndOneCheckedOutBookThatGetsReturned(){
        checkedOutList.add(book1);
        when(book1.isThisMyTitle(title)).thenReturn(true);
        biblioteca.checkInBook(title);
        biblioteca.listBooks();
        verify(book1,times(2)).display();
    }

    @Test
    public void shouldPrintSuccessfulCheckedInMessageWhenBookIsCheckedIn() {
        when(book1.isThisMyTitle(title)).thenReturn(true);
        checkedOutList.add(book1);
        biblioteca.checkInBook(title);
        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldPrintFailedCheckInMessageWhenBookIsNotAvail() throws Exception {
        when(book1.isThisMyTitle(title)).thenReturn(false);
        biblioteca.checkInBook(title);
        verify(printStream).println("That is not a valid book to return.");
    }



}
