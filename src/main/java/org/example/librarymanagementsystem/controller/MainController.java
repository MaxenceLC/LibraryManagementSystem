package org.example.librarymanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    @FXML
    private void showAddBookView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/librarymanagementsystem/AddBookView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Book");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showRemoveBookView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/librarymanagementsystem/RemoveBookView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Remove Book");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showSearchBookView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/librarymanagementsystem/SearchBookView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Search Book");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
