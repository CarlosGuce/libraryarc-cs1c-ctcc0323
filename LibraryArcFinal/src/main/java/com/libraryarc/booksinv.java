package com.libraryarc;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class booksinv extends JFrame {

    private JTable genreTable;
    private JTable inventoryTable;
    private DefaultTableModel genreTableModel;
    private DefaultTableModel inventoryTableModel;
    private final ArrayList<Book> books;
    private final String[] genres = {"Horror", "Romance", "Fantasy", "Fiction", "Science Fiction", "Novel", "Fairy Tale"};

    public booksinv() {
        books = new ArrayList<>();
        initializeBooks();
        initComponents();
    }

    private void initializeBooks() {
        books.add(new Book("Naked in Death", "Horror"));
        books.add(new Book("Happy Place", "Romance"));
        books.add(new Book("Circle", "Fantasy"));
        books.add(new Book("The Hunger Games", "Fiction"));
        books.add(new Book("Dune", "Science Fiction"));
        books.add(new Book("The Alchemist", "Novel"));
        books.add(new Book("Cinderella", "Fairy Tale"));
    }

    private void initComponents() {
        setTitle("Library Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu libraryMenu = new JMenu("Library");
        JMenuItem inventoryMenuItem = new JMenuItem("Manage Inventory");
        libraryMenu.add(inventoryMenuItem);
        menuBar.add(libraryMenu);
        setJMenuBar(menuBar);

        // Genre Table
        String[] columnNames = {"Horror", "Romance", "Fantasy", "Fiction", "Science Fiction", "Novel", "Fairy Tale"};
        genreTableModel = new DefaultTableModel(columnNames, 0);
        genreTable = new JTable(genreTableModel);
        genreTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane genreScrollPane = new JScrollPane(genreTable);
        populateGenreTable();

        // Layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(genreScrollPane, BorderLayout.CENTER);

        // Event Handlers
        inventoryMenuItem.addActionListener((ActionEvent e) -> {
            openInventoryWindow();
        });

    }

    private void populateGenreTable() {
        Object[] row = new Object[genres.length];
        for (Book book : books) {
            for (int i = 0; i < genres.length; i++) {
                if (book.getGenre().equals(genres[i])) {
                    row[i] = book.getTitle();
                }
            }
        }
        genreTableModel.addRow(row);
    }

    private void openInventoryWindow() {
        JFrame inventoryFrame = new JFrame("Manage Inventory");
        inventoryFrame.setSize(800, 500);
        inventoryFrame.setLocationRelativeTo(null);

        // Table
        String[] columnNames = {"Title", "Genre"};
        inventoryTableModel = new DefaultTableModel(columnNames, 0);
        inventoryTable = new JTable(inventoryTableModel);
        JScrollPane inventoryScrollPane = new JScrollPane(inventoryTable);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField titleField = new JTextField();
        JComboBox<String> genreComboBox = new JComboBox<>(genres);

        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Genre:"));
        formPanel.add(genreComboBox);

        JButton addButton = new JButton("ADD");
        JButton deleteButton = new JButton("DELETE");

        formPanel.add(addButton);
        formPanel.add(deleteButton);

        // Layout
        inventoryFrame.getContentPane().setLayout(new BorderLayout());
        inventoryFrame.getContentPane().add(inventoryScrollPane, BorderLayout.CENTER);
        inventoryFrame.getContentPane().add(formPanel, BorderLayout.SOUTH);

        // Populate Inventory Table
        for (Book book : books) {
            inventoryTableModel.addRow(new Object[]{book.getTitle(), book.getGenre()});
        }

        // Event Handlers
        addButton.addActionListener((ActionEvent e) -> {
            String title = titleField.getText();
            String genre = (String) genreComboBox.getSelectedItem();
            Book newBook = new Book(title, genre);
            books.add(newBook);
            inventoryTableModel.addRow(new Object[]{title, genre});
            updateGenreTable();
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            int selectedRow = inventoryTable.getSelectedRow();
            if (selectedRow != -1) {
                books.remove(selectedRow);
                inventoryTableModel.removeRow(selectedRow);
                updateGenreTable();
            }
        });

        inventoryFrame.setVisible(true);
    }

    private void updateGenreTable() {
        genreTableModel.setRowCount(0);
        populateGenreTable();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new booksinv().setVisible(true);
        });
    }

    class Book {
        private final String title;
        private final String genre;

        public Book(String title, String genre) {
            this.title = title;
            this.genre = genre;
        }

        public String getTitle() {
            return title;
        }

        public String getGenre() {
            return genre;
        }

        @Override
        public String toString() {
            return title + " (" + genre + ")";
        }
    }
}
