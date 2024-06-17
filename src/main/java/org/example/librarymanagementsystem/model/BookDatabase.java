package org.example.librarymanagementsystem.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookDatabase {
    private static final String FILE_PATH = "src/main/resources/org/example/librarymanagementsystem/books.json";
    private static ObservableList<Book> books = FXCollections.observableArrayList();

    static {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type bookListType = new TypeToken<ArrayList<Book>>(){}.getType();
            List<Book> bookList = new Gson().fromJson(reader, bookListType);
            books.setAll(bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public static ObservableList<Book> getBooks() {
        return books;
    }

    public static void saveBooks() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(new ArrayList<>(books), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeBook(Book book) {
        books.remove(book);
        saveBooks();
    }
}
