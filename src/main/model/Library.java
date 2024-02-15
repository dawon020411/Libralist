package model;


import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;

    public Library() {
        this.bookList = new ArrayList<>();
    }

    // REQUIRES: book != null
    // MODIFIES: this.bookList
    // EFFECTS: add the specifies book to the library's book list
    public void addBook(Book book) {
        this.bookList.add(book);
    }

    // EFFECTS: return a copy of the book list
    public List<Book> getBookList() {
        return new ArrayList<>(this.bookList);
    }


    // EFFECTS: return a list of books matching the specified search criteria
    public List<Book> searchBook(String title, String author, String publisher,
                                 String publicationDate, String genre) {
        return new ArrayList<>();
    }


    // EFFECTS: return the total number of books in the library
    public int getBookCount() {
        return this.bookList.size();
    }


    // EFFECTS: return the list of books in the library that belong to the
    //          specified genre
    public List<Book> getBookByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : this.bookList) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                result.add(book);
            }
        }
        return result;
    }

}
