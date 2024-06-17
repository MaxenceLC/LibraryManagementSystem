package org.example.librarymanagementsystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.example.librarymanagementsystem.model.Book;
import org.example.librarymanagementsystem.model.BookDatabase;

public class MainController implements Initializable {

    @FXML
    private TableView<Book> bookTable;

    private BookDatabase bookDatabase;
    private ObservableList<Book> bookData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookDatabase = new BookDatabase();
        bookData = FXCollections.observableArrayList(bookDatabase.getBooks());
        bookTable.setItems(bookData);

        // Initialiser d'autres éléments de l'interface utilisateur ici
    }

    @FXML
    private void showAddBookView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/librarymanagementsystem/AddBookView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Book");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
