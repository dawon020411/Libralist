package ui;

import model.Book;
import model.Library;

import java.util.List;
import java.util.Scanner;

public class LibraryApplication {

    private Library library;
    private Scanner scanner; // for user input instance


    public LibraryApplication() {
        this.library = new Library();
        this.scanner = new Scanner(System.in); // user keyboard
    }

    // EFFECTS: display the main menu on the console
    public void displayMenu() {
        System.out.println("1. Add a book");
        System.out.println("2. Display book list");
        System.out.println("3. Search for a book");
        System.out.println("4. Get the books by genre");
        System.out.println("5. Display book count");
        System.out.println("6. Quit");
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


    // EFFECTS: run the program
    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            int choice = getUserInput();
            processUserChoice(choice);
        }
    }


    // EFFECTS: choice
    private void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                addBookUI();
                break;
            case 2:
                displayBookList();
                break;
            case 3:
                searchBookUI();
                break;
            case 4:
                getGenreFilter();
                break;
            case 5:
                displayBookCount();
                break;
            case 6:
                exitApplication();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // EFFECTS: display exit application message
    private void exitApplication() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
