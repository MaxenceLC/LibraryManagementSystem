package org.example.librarymanagementsystem.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    public void showAddBookView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/librarymanagementsystem/AddBookView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Book");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRemoveBookView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/librarymanagementsystem/RemoveBookView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Remove Book");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
