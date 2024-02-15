package ui;

import model.Library;

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
        // stub
    }


    // EFFECTS: return the user's input choice from the menu
    public int getUserInput() {
        return 0;
    }


    // EFFECTS: allow the user to add the book to the library
    public void addBookUI() {
        // stub
    }

    // EFFECTS: display the list of books in the library on the console
    public void displayBookList() {
        // stub
    }


    // EFFECTS: allow user to search the book with categories
    public void searchBookUI() {
        // stub
    }

    // EFFECTS: display the search result
    public void displaySearchResults() {
        // stub
    }


    // EFFECTS: display the total count of books in the library on the console
    public void displayBookCount() {
        // stub
    }

    // EFFECTS: return the genre filter entered by the user
    public String getGenreFilter() {
        return "";
    }
}
