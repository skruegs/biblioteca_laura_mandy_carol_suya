import java.util.List;

public class BookCollection {

    private List<Book> bookList;

    public BookCollection(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void listBooks() {
        for (Book book : bookList) {
            book.display();
        }
    }

    public void moveTo(BookCollection destination, Book book) {
    }

}
