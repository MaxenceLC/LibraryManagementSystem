package org.example.librarymanagementsystem.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.librarymanagementsystem.model.Book;
import org.example.librarymanagementsystem.model.BookDatabase;

public class RemoveBookController {
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
        bookData = BookDatabase.getBooks();

        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));

        bookTable.setItems(bookData);
    }

    @FXML
    private void handleRemoveBook() {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            BookDatabase.removeBook(selectedBook);
            bookData.remove(selectedBook);
        }
    }
}
