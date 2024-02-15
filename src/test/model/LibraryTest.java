package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// Book(String title, String author, String publisher, String pubDate, String genre)
class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Flot Twist", "Dayna",
                "Company A", "2022-01-01", "Academic");
        book2 = new Book("Love Story", "Andy",
                "Company A", "2022-02-02", "Romance");
        book3 = new Book("Bears House", "Bryan",
                "Company B", "2022-02-02", "Fairytale");
        book4 = new Book("Calculus 2", "Gregor",
                "Company C", "2022-03-03", "Academic");
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        library.addBook(book2);

        assertEquals(library.getBookList().get(1).getTitle(), "Love Story");
        assertEquals(library.getBookList().get(1).getPublisher(), "Company A");

        assertEquals(2, library.getBookCount());
    }

    @Test
    public void testGetBookList() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        assertEquals(1, library.searchBook("Love Story", "",
                "", "","").size());
        assertEquals(2, library.searchBook("", "",
                "", "2022-02-02","").size());
        assertEquals(0, library.searchBook("WHAT", "",
                "", "","").size());
    }

    @Test
    public void testGetBookCount() {
        assertEquals(0, library.getBookCount());

        library.addBook(book1);
        assertEquals(1, library.getBookCount());

        library.addBook(book4);
        assertEquals(2, library.getBookCount());
    }

    @Test
    public void testGetBookByGenre() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        List<Book> AcademicBooks = new ArrayList<>();
        AcademicBooks.add(book1);
        AcademicBooks.add(book4);
        List<Book> FairyTaleBooks = new ArrayList<>();
        FairyTaleBooks.add(book2);


        assertEquals("Bryan", library.getBookList().get(2).getAuthor());
        assertEquals("Academic", library.getBookList().get(0).getGenre());
        assertEquals("2022-03-03", library.getBookList().get(3).getPubDate());

        assertEquals(AcademicBooks, library.getBookByGenre("Academic"));
        assertEquals(FairyTaleBooks, library.getBookByGenre("Fairytale"));
        assertEquals(new ArrayList<>(), library.getBookByGenre("WHAT"));
    }
}