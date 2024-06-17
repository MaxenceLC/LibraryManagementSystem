package org.example.librarymanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.librarymanagementsystem.model.Book;
import org.example.librarymanagementsystem.model.BookDatabase;

public class AddBookController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;

    @FXML
    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();

        if (!title.isEmpty() && !author.isEmpty()) {
            Book book = new Book(title, author);
            BookDatabase.addBook(book);
        }
    }
}
