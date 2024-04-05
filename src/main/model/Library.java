package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// This Library class is where all books will be stored in the form of ArrayList
public class Library implements Writable {
    private List<Book> bookList;

    // EFFECTS: generate the new ArrayList to store all books' information.
    public Library() {
        this.bookList = new ArrayList<>();
    }

    // REQUIRES: book != null
    // MODIFIES: this.bookList
    // EFFECTS: add the specifies book to the library's book list and log the event
    public void addBook(Book book) {
        this.bookList.add(book);
        EventLog.getInstance().logEvent(new Event("A book is added to the Library."));
    }

    // EFFECTS: return a copy of the book list
    public List<Book> getBookList() {
        return this.bookList;
    }


    // EFFECTS: return a list of books matching the specified search criteria and print a message
    public List<Book> searchBook(String title, String author, String publisher,
                                 String publicationDate, String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : this.bookList) {
            if (book.getTitle().equalsIgnoreCase(title)
                    ||
                    book.getAuthor().equalsIgnoreCase(author)
                    ||
                    book.getPublisher().equalsIgnoreCase(publisher)
                    ||
                    book.getPubDate().equalsIgnoreCase(publicationDate)
                    ||
                    book.getGenre().equalsIgnoreCase(genre)) {
                result.add(book);
            }
        }
        EventLog.getInstance().logEvent(new Event("A book is searched from the Library."));
        return result;
    }


    // EFFECTS: return the total number of books in the library and print a message
    public int getBookCount() {
        EventLog.getInstance().logEvent(new Event("The number of books in the Library is counted."));
        return this.bookList.size();
    }


    // EFFECTS: return the list of books in the library that belong to the
    //          specified genre and print a message
    public List<Book> getBookByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : this.bookList) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                result.add(book);
            }
        }
        EventLog.getInstance().logEvent(new Event("A book is searched by genre from the Library."));
        return result;
    }

    // EFFECTS: put bookList to JSONObject and return it
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("bookList", bookListToJson());
        return json;
    }

    // EFFECTS: returns book list in the library as a JSON array
    private JSONArray bookListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Book book : bookList) {
            jsonArray.put(book.toJson());
        }

        return jsonArray;
    }
}
