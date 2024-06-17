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
    @FXML
    private void showCheckOutBookView() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/librarymanagementsystem/CheckOutBookView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Check Out Book");
        stage.show();
    }

    @FXML
    private void showReturnBookView() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/librarymanagementsystem/ReturnBookView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Return Book");
        stage.show();
    }

}
