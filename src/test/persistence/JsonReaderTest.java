package persistence;

import model.Book;
import model.Library;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Library library = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyLibrary.json");
        try {
            Library library = reader.read();
            assertEquals(0, library.getBookCount());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralLibrary.json");
        try {
            Library library = reader.read();
            List<Book> books = library.getBookList();
            assertEquals(2, books.size());
            checkBook("Romeo", "Dayna", "Company A", "2004-02-04", "Romance", books.get(0));
            checkBook("Calculus 3", "Trueman", "Company B", "2022-12-31", "Academic", books.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}