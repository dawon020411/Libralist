package model;


public class Book {
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


}
