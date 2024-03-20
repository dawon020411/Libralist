package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;


// EFFECTS: Graphic User Interface (GUI) for Libralist application
public class LibralistAppGUI extends JFrame {

    // setUp fields!
    private static final String JSON_STORE = "./data/library.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private final CardLayout cardLayout = new CardLayout();

    // start
    private final JFrame jframe = new JFrame("Libralist");
    private final JPanel panelTransition = new JPanel();
    private JPanel startPanel = new JPanel();
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
    private final JLabel savedLabel = new JLabel("");
    private final JLabel loadedLabel = new JLabel("");

    // add screen
    private final JPanel addPanel = new JPanel();
    private final JLabel titleLabel = new JLabel("Enter book title:");
    private final JLabel authorLabel = new JLabel("Enter author name:");
    private final JLabel publisherLabel = new JLabel("Enter publisher name:");
    private final JLabel pubDateLabel = new JLabel("Enter publication date (YYYY-MM-DD):");
    private final JLabel genreDateLabel = new JLabel("Enter book's genre:");
    private final JTextField addTextField = new JTextField();
    private final JTextField titleTextField = new JTextField();
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
    private final JTextField addSearchTextField = new JTextField();
    private final JTextField titleSearchTextField = new JTextField();
    private final JTextField publisherSearchTextField = new JTextField();
    private final JTextField pubDateSearchTextField = new JTextField();
    private final JTextField genreSearchTextField = new JTextField();
    private final JButton searchBookButton = new JButton("Search");
    private final JButton searchToBackButton = new JButton("back");

    // get book by genre screen
    private final JPanel genrePanel = new JPanel();
    private final JButton genreToBackButton = new JButton("Back");
    private final JTextField getGenreTextField = new JTextField();
    private final JButton genreFilterButton = new JButton("Filter");
    private DefaultListModel genreList = new DefaultListModel();
    private JList genreBooks = new JList(genreList);

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
        panelTransition.add(displayBooks, "4");
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
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(252, 237, 154));
    }

    // EFFECTS: set the add screen
    public void setAddPanel() {
        addPanel.setLayout(null);
        addPanel.setBackground(new Color(197, 255, 178));
    }

    // EFFECTS: set the display screen
    public void setDisplayPanel() {
        displayPanel.setLayout(null);
        displayPanel.setBackground(new Color(215, 255, 246));
    }

    // EFFECTS: set the search screen
    public void setSearchPanel() {
        searchPanel.setLayout(null);
        searchPanel.setBackground(new Color(204, 215, 255));
    }

    // EFFECTS: set the genre screen
    public void setGenrePanel() {
        genrePanel.setLayout(null);
        genrePanel.setBackground(new Color(199, 161, 255));
    }

    public void actionPerformed() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelTransition, "2");
            }
        });
    }

}
