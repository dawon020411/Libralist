package persistence;

import model.Book;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class JsonTest {
    protected void checkBook(String title, String author, String publisher, String pubDate, String genre, Book book) {
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(publisher, book.getPublisher());
        assertEquals(pubDate, book.getPubDate());
        assertEquals(genre, book.getGenre());
    }
}
