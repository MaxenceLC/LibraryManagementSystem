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
    private static List<Book> books = new ArrayList<>();

    static {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type bookListType = new TypeToken<ArrayList<Book>>() {}.getType();
            books = new Gson().fromJson(reader, bookListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }

    public static void removeBook(Book book) {
        books.remove(book);
        saveBooksToFile();
    }

    public static ObservableList<Book> getBooks() {
        return FXCollections.observableArrayList(books);
    }

    public static Book getBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public static void saveBooksToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(new ArrayList<>(books), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
