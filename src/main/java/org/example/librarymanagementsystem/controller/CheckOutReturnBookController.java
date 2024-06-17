package org.example.librarymanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.librarymanagementsystem.model.Book;
import org.example.librarymanagementsystem.model.BookDatabase;

public class CheckOutReturnBookController {
    @FXML
    private TextField isbnField;
    @FXML
    private TextField userIdField;

    @FXML
    private void handleCheckOutBook() {
        String isbn = isbnField.getText();
        String userId = userIdField.getText();
        Book book = BookDatabase.getBookByISBN(isbn);
        if (book != null && !book.isCheckedOut()) {
            book.setCheckedOut(true);
            book.setUserId(userId);
            BookDatabase.saveBooksToFile();
            showConfirmationMessage("Book checked out successfully.");
        } else {
            showErrorMessage("Book is not available for checkout.");
        }
    }

    @FXML
    private void handleReturnBook() {
        String isbn = isbnField.getText();
        Book book = BookDatabase.getBookByISBN(isbn);
        if (book != null && book.isCheckedOut()) {
            book.setCheckedOut(false);
            book.setUserId(null);
            BookDatabase.saveBooksToFile();
            showConfirmationMessage("Book returned successfully.");
        } else {
            showErrorMessage("Book is not available for return.");
        }
    }

    private void showConfirmationMessage(String message) {
        // Implementation to show confirmation message
    }

    private void showErrorMessage(String message) {
        // Implementation to show error message
    }
}
