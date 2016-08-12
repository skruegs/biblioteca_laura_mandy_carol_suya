import java.util.List;

public class Biblioteca {

    private List<Book> bookList;

    public Biblioteca(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void listBooks() {
        for (Book book: bookList) {
            book.display();
        }
    }

    public void checkOutBook() {
    }
}
