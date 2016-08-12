import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookCollectionTest {

    private List<Book> bookList;
    private Book book;
    private BookCollection bookCollection1;
    private BookCollection bookCollection2;

    @Before
    public void setUp() throws Exception {
        bookList = new ArrayList<>();
        book = mock(Book.class);
        bookList.add(book);
        bookCollection1 = new BookCollection(bookList);
        bookCollection2 = mock(BookCollection.class);
    }

    @Test
    public void shouldCallPrintOnceWithBookListSizeOne(){
        bookCollection1.listBooks();
        verify(book,times(1)).display();
    }

    @Test
    public void shouldCallPrintTwiceWithBookListSizeTwo(){
        bookList.add(book);
        bookCollection1.listBooks();
        verify(book, times(2)).display();
    }

    @Test
    @Ignore
    public void shouldNotHaveAnyBooksWhenItHadOnlyOneBookAndThatBookMoves() {

        bookCollection1.moveTo(bookCollection2, book);


    }

    @Test
    @Ignore
    public void shouldHaveABookWhenCollectionWasEmptyAndABookWasMovedToIt() throws Exception {

    }

}