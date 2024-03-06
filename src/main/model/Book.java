package model;

import org.json.JSONObject;
import persistence.Writable;

public class Book implements Writable {
    private final String title;
    private final String author;
    private final String publisher;
    private final String pubDate;
    private final String genre;

    public Book(String title, String author, String publisher, String pubDate, String genre) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
        this.genre = genre;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public String getGenre() {
        return this.genre;
    }

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
