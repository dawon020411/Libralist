package ui;

import model.Book;
import model.Event;
import model.EventLog;
import model.Library;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// EFFECTS: application of the Library.
public class LibraryApplication {
    private static final String JSON_STORE = "./data/library.json";
    private Library library;
    private Scanner scanner; // for user input instance
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: set a objects of fields to new object.
    public LibraryApplication() {
        this.library = new Library();
        this.scanner = new Scanner(System.in); // user keyboard
        this.jsonWriter = new JsonWriter(JSON_STORE);
        this.jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: run the program
    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            int choice = getUserInput();
            processUserChoice(choice);
        }
    }

    // EFFECTS: display the main menu on the console
    public void displayMenu() {
        System.out.println("Select from:");
        System.out.println("1. Add a book");
        System.out.println("2. Display book list");
        System.out.println("3. Search for a book");
        System.out.println("4. Get the books by genre");
        System.out.println("5. Display book count");
        System.out.println("6. Save this library");
        System.out.println("7. Load saved library");
        System.out.println("8. Quit");
    }

    // EFFECTS: choice
    private void processUserChoice(int choice) {
        if (choice == 1) {
            addBookUI();
        } else if (choice == 2) {
            displayBookList();
        } else if (choice == 3) {
            searchBookUI();
        } else if (choice == 4) {
            getGenreFilter();
        } else if (choice == 5) {
            displayBookCount();
        } else if (choice == 6) {
            saveLibrary();
        } else if (choice == 7) {
            loadLibrary();
        } else if (choice == 8) {
            exitApplication();
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }


    // EFFECTS: return the user's input choice from the menu
    public int getUserInput() {
        System.out.println("Enter your choice: ");
        return scanner.nextInt();
    }


    // EFFECTS: allow the user to add the book to the library
    public void addBookUI() {
        System.out.print("Enter book title: ");
        String title = scanner.next();
        System.out.print("Enter author name: ");
        String author = scanner.next();
        System.out.print("Enter publisher name: ");
        String publisher = scanner.next();
        System.out.print("Enter publication date (YYYY-MM-DD): ");
        String pubDate = scanner.next();
        System.out.print("Enter genre: ");
        String genre = scanner.next();

        Book book = new Book(title, author, publisher, pubDate, genre);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    // EFFECTS: display the list of books in the library on the console
    public void displayBookList() {
        List<Book> books = library.getBookList();
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }


    // EFFECTS: allow user to search the book with categories
    public void searchBookUI() {
        System.out.print("Enter book title: ");
        String title = scanner.next();
        System.out.print("Enter author name: ");
        String author = scanner.next();
        System.out.print("Enter publisher name: ");
        String publisher = scanner.next();
        System.out.print("Enter publication date (YYYY-MM-DD): ");
        String pubDate = scanner.next();
        System.out.print("Enter genre: ");
        String genre = scanner.next();

        List<Book> searchResults = library.searchBook(title, author, publisher, pubDate, genre);
        System.out.println("Search results:");
        for (Book result : searchResults) {
            System.out.println(result.getTitle() + " by " + result.getAuthor());
        }
    }


    // EFFECTS: display the total count of books in the library on the console
    public void displayBookCount() {
        int bookCount = library.getBookCount();
        System.out.println("Total number of books: " + bookCount);
    }

    // EFFECTS: return the genre filter entered by the user
    public void getGenreFilter() {
        System.out.print("Enter genre for filtering: ");
        String genre = scanner.next();

        List<Book> genreResults = library.getBookByGenre(genre);
        System.out.println("Search results:");
        for (Book result : genreResults) {
            System.out.println(result.getTitle() + " by " + result.getAuthor());
        }
    }

    // EFFECT: saves the library to file
    private void saveLibrary() {
        try {
            jsonWriter.open();
            jsonWriter.write(library);
            jsonWriter.close();
            System.out.println("Saved!");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadLibrary() {
        try {
            library = jsonReader.read();
            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    // EFFECTS: display exit application message
    private void exitApplication() {
        System.out.println("Goodbye!");
        for (Event event : EventLog.getInstance()) {
            System.out.println(event.toString());
        }
        System.exit(0);
    }
}
