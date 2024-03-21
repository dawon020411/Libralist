package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.swing.SwingUtilities;


// EFFECTS: Graphic User Interface (GUI) for Libralist application
public class LibralistAppGUI extends JFrame {

    // setUp fields!
    private static final String JSON_STORE = "./data/GUILibrary.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private final CardLayout cardLayout = new CardLayout();

    // start
    private final JFrame jframe = new JFrame("Libralist");
    private final JPanel panelTransition = new JPanel();
    private final JPanel startPanel = new JPanel();
    private final JButton startButton = new JButton("Welcome to your Libralist");

    // all buttons
    private final JPanel mainPanel = new JPanel();
    private final JButton addButton = new JButton("Add a Book");
    private final JButton displayButton = new JButton("Display Book List");
    private final JButton searchButton = new JButton("Search Your Book");
    private final JButton genreButton = new JButton("Get the Books by Genre");
    private final JButton bookCountButton = new JButton("Display Book Count");
    private final JButton saveButton = new JButton("Save Your Library");
    private final JButton loadButton = new JButton("Load Your Library");
    private final JButton quitButton = new JButton("Quit");

    // add screen
    private final JPanel addPanel = new JPanel();
    private final JLabel titleLabel = new JLabel("Enter book title:");
    private final JLabel authorLabel = new JLabel("Enter author name:");
    private final JLabel publisherLabel = new JLabel("Enter publisher name:");
    private final JLabel pubDateLabel = new JLabel("Enter publication date (YYYY-MM-DD):");
    private final JLabel genreDateLabel = new JLabel("Enter book's genre:");
    private final JTextField titleTextField = new JTextField();
    private final JTextField authorTextField = new JTextField();
    private final JTextField publisherTextField = new JTextField();
    private final JTextField pubDateTextField = new JTextField();
    private final JTextField genreTextField = new JTextField();
    private final JButton addBookButton = new JButton("Add");
    private final JButton addToBackButton = new JButton("back");

    // display screen
    private final JPanel displayPanel = new JPanel();
    private DefaultListModel bookList = new DefaultListModel();
    private JList displayBooks = new JList(bookList);
    private Library library = new Library();
    private final JButton displayToBackButton = new JButton("back");

    // search screen
    private final JPanel searchPanel = new JPanel();
    private final JLabel titleSearchLabel = new JLabel("Enter book title:");
    private final JLabel authorSearchLabel = new JLabel("Enter author name:");
    private final JLabel publisherSearchLabel = new JLabel("Enter publisher name:");
    private final JLabel pubDateSearchLabel = new JLabel("Enter publication date (YYYY-MM-DD):");
    private final JLabel genreDateSearchLabel = new JLabel("Enter book's genre:");
    private final JTextField titleSearchTextField = new JTextField();
    private final JTextField authorSearchTextField = new JTextField();
    private final JTextField publisherSearchTextField = new JTextField();
    private final JTextField pubDateSearchTextField = new JTextField();
    private final JTextField genreSearchTextField = new JTextField();
    private final JButton searchBookButton = new JButton("Search");
    private final JButton searchToBackButton = new JButton("back");
    private DefaultListModel bookSearchList = new DefaultListModel();
    private JList searchBooks = new JList(bookSearchList);

    // get book by genre screen
    private final JPanel genrePanel = new JPanel();
    private final JLabel getGenreLabel = new JLabel("What genre of book are you looking for?");
    private final JTextField getGenreTextField = new JTextField();
    private final JButton genreFilterButton = new JButton("Filter");
    private final JButton genreToBackButton = new JButton("Back");
    private DefaultListModel genreList = new DefaultListModel();
    private JList genreBooks = new JList(genreList);

    // EFFECTS: run the application with GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibralistAppGUI();
            }
        });
    }


    // EFFECTS: Stack a panels and set the layout
    public LibralistAppGUI() {
        panelTransition.setLayout(cardLayout);
        panelTransition.add(startPanel,"1");
        panelTransition.add(mainPanel, "2");
        panelTransition.add(addPanel, "3");
        panelTransition.add(displayPanel, "4");
        panelTransition.add(searchPanel, "5");
        panelTransition.add(genrePanel, "6");

        cardLayout.show(panelTransition, "1");
        setStartPanel();
        setMainPanel();
        setAddPanel();
        setDisplayPanel();
        setSearchPanel();
        setGenrePanel();
        actionPerformed();
        jframe.add(panelTransition);
        jframe.setSize(600, 800);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setVisible(true);
    }

    // EFFECTS: set the start screen
    public void setStartPanel() {
        startPanel.setLayout(null);
        startPanel.setBackground(new Color(229, 195, 172));
        startButton.setBounds(200, 500, 200, 80);
        startPanel.add(startButton);
    }

    // EFFECTS: set the main screen
    public void setMainPanel() {
        int buttonWidth = 200;
        int buttonHeight = 50;
        int initialX = 200;
        int initialY = 150;
        int spacing = 10;
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(252, 237, 154));

        addButton.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        displayButton.setBounds(initialX, initialY + buttonHeight + spacing, buttonWidth, buttonHeight);
        searchButton.setBounds(initialX, initialY + 2 * (buttonHeight + spacing), buttonWidth, buttonHeight);
        genreButton.setBounds(initialX, initialY + 3 * (buttonHeight + spacing), buttonWidth, buttonHeight);
        bookCountButton.setBounds(initialX, initialY + 4 * (buttonHeight + spacing), buttonWidth, buttonHeight);
        saveButton.setBounds(initialX, initialY + 5 * (buttonHeight + spacing), buttonWidth, buttonHeight);
        loadButton.setBounds(initialX, initialY + 6 * (buttonHeight + spacing), buttonWidth, buttonHeight);
        quitButton.setBounds(initialX, initialY + 7 * (buttonHeight + spacing), buttonWidth, buttonHeight);
        mainPanel.add(addButton);
        mainPanel.add(displayButton);
        mainPanel.add(searchButton);
        mainPanel.add(genreButton);
        mainPanel.add(bookCountButton);
        mainPanel.add(saveButton);
        mainPanel.add(loadButton);
        mainPanel.add(quitButton);
    }

    // EFFECTS: set the add screen
    public void setAddPanel() {
        int labelX = 70;
        int spacing = 50;
        int labelHeight = 20;
        int textX = 330;
        int textWidth = 175;
        int textHeight = 35;
        addPanel.setLayout(null);
        addPanel.setBackground(new Color(197, 255, 178));

        titleLabel.setBounds(labelX, 100, 100, labelHeight);
        authorLabel.setBounds(labelX, 100 + labelHeight + spacing, 150, labelHeight);
        publisherLabel.setBounds(labelX, 100 + 2 * (labelHeight + spacing), 175, labelHeight);
        pubDateLabel.setBounds(labelX, 100 + 3 * (labelHeight + spacing), 230, labelHeight);
        genreDateLabel.setBounds(labelX, 100 + 4 * (labelHeight + spacing), 150, labelHeight);
        addPanel.add(titleLabel);
        addPanel.add(authorLabel);
        addPanel.add(publisherLabel);
        addPanel.add(pubDateLabel);
        addPanel.add(genreDateLabel);
        titleTextField.setBounds(textX, 100, textWidth, textHeight);
        authorTextField.setBounds(textX, 100 + labelHeight + spacing, textWidth, textHeight);
        publisherTextField.setBounds(textX, 100 + 2 * (labelHeight + spacing), textWidth, textHeight);
        pubDateTextField.setBounds(textX, 100 + 3 * (labelHeight + spacing), textWidth, textHeight);
        genreTextField.setBounds(textX, 100 + 4 * (labelHeight + spacing), textWidth, textHeight);
        addPanel.add(titleTextField);
        addPanel.add(authorTextField);
        addPanel.add(publisherTextField);
        addPanel.add(pubDateTextField);
        addPanel.add(genreTextField);
        addBookButton.setBounds(200, 500, 200, 80);
        addPanel.add(addBookButton);
        addToBackButton.setBounds(250, 650, 100, 35);
        addPanel.add(addToBackButton);
    }

    // EFFECTS: set the display screen
    public void setDisplayPanel() {
        displayPanel.setLayout(null);
        displayPanel.setBackground(new Color(215, 255, 246));

        displayToBackButton.setBounds(250, 650, 100, 35);
        displayPanel.add(displayToBackButton);

        displayBooks.setBounds(150, 150, 300, 400);
        displayPanel.add(displayBooks);
    }

    // EFFECTS: set the search screen
    public void setSearchPanel() {
        searchPanel.setLayout(null);
        searchPanel.setBackground(new Color(204, 215, 255));
        int labelX = 70;
        int spacing = 50;
        int labelHeight = 20;
        int textX = 330;
        int textWidth = 175;
        int textHeight = 35;
        titleSearchLabel.setBounds(labelX, 80, 100, labelHeight);
        authorSearchLabel.setBounds(labelX, 80 + labelHeight + spacing, 150, labelHeight);
        publisherSearchLabel.setBounds(labelX, 80 + 2 * (labelHeight + spacing), 175, labelHeight);
        pubDateSearchLabel.setBounds(labelX, 80 + 3 * (labelHeight + spacing), 230, labelHeight);
        genreDateSearchLabel.setBounds(labelX, 80 + 4 * (labelHeight + spacing), 150, labelHeight);
        searchPanel.add(titleSearchLabel);
        searchPanel.add(authorSearchLabel);
        searchPanel.add(publisherSearchLabel);
        searchPanel.add(pubDateSearchLabel);
        searchPanel.add(genreDateSearchLabel);
        titleSearchTextField.setBounds(textX, 80, textWidth, textHeight);
        authorSearchTextField.setBounds(textX, 80 + labelHeight + spacing, textWidth, textHeight);
        publisherSearchTextField.setBounds(textX, 80 + 2 * (labelHeight + spacing), textWidth, textHeight);
        pubDateSearchTextField.setBounds(textX, 80 + 3 * (labelHeight + spacing), textWidth, textHeight);
        genreSearchTextField.setBounds(textX, 80 + 4 * (labelHeight + spacing), textWidth, textHeight);
        searchPanel.add(titleSearchTextField);
        searchPanel.add(authorSearchTextField);
        searchPanel.add(publisherSearchTextField);
        searchPanel.add(pubDateSearchTextField);
        searchPanel.add(genreSearchTextField);
        searchBookButton.setBounds(110, 650, 200, 80);
        searchPanel.add(searchBookButton);
        searchToBackButton.setBounds(370, 675, 100, 35);
        searchPanel.add(searchToBackButton);
        searchBooks.setBounds(labelX, 80 + 5 * (labelHeight + spacing), 420, 190);
        searchPanel.add(searchBooks);
    }

    // EFFECTS: set the genre screen
    public void setGenrePanel() {
        genrePanel.setLayout(null);
        genrePanel.setBackground(new Color(199, 161, 255));

        getGenreLabel.setBounds(180, 80, 250, 20);
        genrePanel.add(getGenreLabel);

        getGenreTextField.setBounds(212, 120, 176, 35);
        genrePanel.add(getGenreTextField);

        genreFilterButton.setBounds(232, 190, 136, 35);
        genrePanel.add(genreFilterButton);

        genreToBackButton.setBounds(250, 650, 100, 35);
        genrePanel.add(genreToBackButton);

        genreBooks.setBounds(125, 290, 350, 280);
        genrePanel.add(genreBooks);
    }

    public void actionPerformed() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "2");
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "3");
            }
        });

        addToBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "2");
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "4");
            }
        });

        displayToBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "2");
            }
        });

        genreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "6");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "5");
            }
        });

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();
                String author = authorTextField.getText();
                String publisher = publisherTextField.getText();
                String pubDate = pubDateTextField.getText();
                String genre = genreTextField.getText();

                Book newBook = new Book(title, author, publisher, pubDate, genre);

                library.addBook(newBook);
                bookList.addElement(newBook.getTitle());
                clearAddPanelTextFields();
                JOptionPane.showMessageDialog(null, "Added a book successfully!");
            }
        });

        searchBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleSearchTextField.getText();
                String author = authorSearchTextField.getText();
                String publisher = publisherSearchTextField.getText();
                String pubDate = pubDateSearchTextField.getText();
                String genre = genreSearchTextField.getText();
                clearAddPanelTextFields();
                bookSearchList.clear();

                List<Book> searchResult = library.searchBook(title, author, publisher, pubDate, genre);

                for (Book book : searchResult) {
                    bookSearchList.addElement(book.getTitle());
                }
            }
        });

        genreFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genre = getGenreTextField.getText();
                clearAddPanelTextFields();
                genreList.clear();

                List<Book> genreResult = library.getBookByGenre(genre);

                for (Book book : genreResult) {
                    genreList.addElement(book.getTitle());
                }
            }
        });

        searchToBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "2");
            }
        });

        genreToBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "2");
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter = new JsonWriter(JSON_STORE);
                    jsonWriter.open();
                    jsonWriter.write(library);
                    jsonWriter.close();
                    JOptionPane.showMessageDialog(null, "Saved successfully!");
                } catch (FileNotFoundException exception) {
                    JOptionPane.showMessageDialog(null, "Error: Unable to write to file");
                }
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsonReader = new JsonReader(JSON_STORE);
                try {
                    Library loadedLibrary = jsonReader.read();
                    for (Book book : loadedLibrary.getBookList()) {
                        library.addBook(book);
                        bookList.addElement(book.getTitle());
                    }
                    JOptionPane.showMessageDialog(null, "Loaded successfully!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Failed to load library.");
                }
            }
        });

        bookCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bookCount = library.getBookCount();
                JOptionPane.showMessageDialog(null, "Total number of books: " + bookCount);
            }
        });
    }

    private void clearAddPanelTextFields() {
        titleTextField.setText("");
        authorTextField.setText("");
        publisherTextField.setText("");
        pubDateTextField.setText("");
        genreTextField.setText("");

        titleSearchTextField.setText("");
        authorSearchTextField.setText("");
        publisherSearchTextField.setText("");
        pubDateSearchTextField.setText("");
        genreSearchTextField.setText("");

        getGenreTextField.setText("");
    }

}
