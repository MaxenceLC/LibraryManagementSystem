package org.example.librarymanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.librarymanagementsystem.model.Book;
import org.example.librarymanagementsystem.model.BookDatabase;

public class AddBookController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField isbnField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField yearField;

    @FXML
    private void handleAddBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();
        String genre = genreField.getText();
        String yearText = yearField.getText();

        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || genre.isEmpty() || yearText.isEmpty()) {
            showErrorMessage("All fields must be filled.");
            return;
        }

        int publicationYear;
        try {
            publicationYear = Integer.parseInt(yearText);
        } catch (NumberFormatException e) {
            showErrorMessage("Publication Year must be a valid number.");
            return;
        }

        Book newBook = new Book(title, author, isbn, genre, publicationYear, false);
        BookDatabase.addBook(newBook);
        clearFields();
        showConfirmationMessage("Book added successfully.");
    }

    @FXML
    private void handleCancel() {
        clearFields();
    }

    private void clearFields() {
        titleField.clear();
        authorField.clear();
        isbnField.clear();
        genreField.clear();
        yearField.clear();
    }

    private void showConfirmationMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
