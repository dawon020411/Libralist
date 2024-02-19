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
    public void testGetBookList() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> expectedList = new ArrayList<>();
        expectedList.add(book1);
        expectedList.add(book2);
        expectedList.add(book3);

        assertEquals(expectedList, library.getBookList());
    }


    @Test
    public void testAddBook() {
        library.addBook(book1);
        library.addBook(book2);

        assertEquals(2, library.getBookCount());
    }

    @Test
    public void testSearchBook() {
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
        FairyTaleBooks.add(book3);


        assertEquals(AcademicBooks, library.getBookByGenre("Academic"));
        assertEquals(FairyTaleBooks, library.getBookByGenre("Fairytale"));
        assertEquals(new ArrayList<>(), library.getBookByGenre("WHAT"));
    }


    @Test
    public void testGetNoBookByGenre() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        List<Book> AcademicBooks = new ArrayList<>();
        AcademicBooks.add(book1);
        AcademicBooks.add(book4);
        List<Book> FairyTaleBooks = new ArrayList<>();
        FairyTaleBooks.add(book3);


        assertEquals(AcademicBooks, library.getBookByGenre("ACADEMIC"));
        assertEquals(FairyTaleBooks, library.getBookByGenre("fairytale"));
        assertEquals(new ArrayList<>(), library.getBookByGenre("WHAT"));
    }

    @Test
    public void testGetNoBookByGenreIgnoreCase() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        assertEquals(new ArrayList<>(), library.getBookByGenre("WHAT"));
    }


    @Test
    public void testGetTitle() {
        assertEquals("Flot Twist", book1.getTitle());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Dayna", book1.getAuthor());
    }

    @Test
    public void testGetPublisher() {
        assertEquals("Company B", book3.getPublisher());
    }

    @Test
    public void TestGetPubDate() {
        assertEquals("2022-02-02", book2.getPubDate());
    }


    @Test
    public void testGetGenre() {
        assertEquals("Academic", book4.getGenre());

    }
}