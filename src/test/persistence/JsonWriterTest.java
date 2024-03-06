package persistence;

import model.Book;
import model.Library;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            Library library = new Library();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Library library = new Library();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyLibrary.json");
            writer.open();
            writer.write(library);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyLibrary.json");
            library = reader.read();
            assertEquals(0, library.getBookCount());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Library library = new Library();
            library.addBook(new Book("Romeo", "Dayna", "Company A", "2004-02-04", "Romance"));
            library.addBook(new Book("Calculus 3", "Trueman", "Company B", "2022-12-31", "Academic"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralLibrary.json");
            writer.open();
            writer.write(library);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralLibrary.json");
            library = reader.read();
            List<Book> books = library.getBookList();
            assertEquals(2, books.size());
            checkBook("Romeo", "Dayna", "Company A", "2004-02-04", "Romance", books.get(0));
            checkBook("Calculus 3", "Trueman", "Company B", "2022-12-31", "Academic", books.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}