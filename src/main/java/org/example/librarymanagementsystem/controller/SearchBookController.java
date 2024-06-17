package org.example.librarymanagementsystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.librarymanagementsystem.model.Book;
import org.example.librarymanagementsystem.model.BookDatabase;

public class SearchBookController {
    @FXML
    private TextField searchField;
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> isbnColumn;

    private ObservableList<Book> bookData;

    @FXML
    private void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));

        bookData = FXCollections.observableArrayList();
        bookTable.setItems(bookData);
    }

    @FXML
    private void handleSearchBook() {
        String searchText = searchField.getText().toLowerCase();
        ObservableList<Book> searchResults = FXCollections.observableArrayList();

        for (Book book : BookDatabase.getBooks()) {
            if (book.getTitle().toLowerCase().contains(searchText) ||
                    book.getAuthor().toLowerCase().contains(searchText) ||
                    book.getIsbn().toLowerCase().contains(searchText)) {
                searchResults.add(book);
            }
        }

        if (searchResults.isEmpty()) {
            bookTable.setPlaceholder(new javafx.scene.control.Label("No books found."));
        }
        bookTable.setItems(searchResults);
    }
}
