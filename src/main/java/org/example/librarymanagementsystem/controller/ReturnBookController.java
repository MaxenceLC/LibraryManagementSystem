package org.example.librarymanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.librarymanagementsystem.model.Book;
import org.example.librarymanagementsystem.model.BookDatabase;

public class ReturnBookController {
    @FXML
    private TextField isbnField;

    @FXML
    private void handleReturnBook() {
        String isbn = isbnField.getText();
        Book book = BookDatabase.getBookByISBN(isbn);
        if (book != null && book.isCheckedOut()) {
            book.setCheckedOut(false);
            book.setUserId(null);
            BookDatabase.saveBooksToFile();
        }
    }
}
