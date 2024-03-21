package model;

import org.json.JSONObject;
import persistence.Writable;

// This Book class is where all the book's infomation are stored.
public class Book implements Writable {
    private final String title;
    private final String author;
    private final String publisher;
    private final String pubDate;
    private final String genre;

    // REQUIRED: title should have length > 0, pubDate should be in the form of (YYYY-MM-DD)
    // EFFECTS: set all the book information such as title, author, publisher, pubDate (YYYY-MM-DD),
    //          and genre
    public Book(String title, String author, String publisher, String pubDate, String genre) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
        this.genre = genre;
    }

    // EFFECTS: get tile of the book
    public String getTitle() {
        return this.title;
    }

    // EFFECTS: get author of the book
    public String getAuthor() {
        return this.author;
    }

    // EFFECTS: get publisher of the book
    public String getPublisher() {
        return this.publisher;
    }

    // EFFECTS: get publication date of the book
    public String getPubDate() {
        return this.pubDate;
    }

    // get genre of the book
    public String getGenre() {
        return this.genre;
    }

    // EFFECTS: get the data from the book objects, and return it to json to save the data to file
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("author", author);
        json.put("publisher", publisher);
        json.put("pubDate", pubDate);
        json.put("genre", genre);
        return json;
    }

}
