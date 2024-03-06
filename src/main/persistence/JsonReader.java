package persistence;

import model.Book;
import model.Library;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads library from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads library from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Library read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses library from JSON object and returns it
    private Library parseWorkRoom(JSONObject jsonObject) {
        Library library = new Library();
        addBooks(library, jsonObject);
        return library;
    }

    // MODIFIES: library
    // EFFECTS: parses books from JSON object and adds them to library
    private void addBooks(Library library, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("bookList");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addBook(library, nextThingy);
        }
    }

    // MODIFIES: library
    // EFFECTS: parses book from JSON object and adds it to library
    private void addBook(Library library, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String author = jsonObject.getString("author");
        String publisher = jsonObject.getString("publisher");
        String pubDate = jsonObject.getString("pubDate");
        String genre = jsonObject.getString("genre");
        Book book = new Book(title, author, publisher, pubDate, genre);
        library.addBook(book);
    }
}