import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LibrarianItemsScene implements Initializable {
    @FXML
    private Label nameLabel;
    @FXML
    private Label libraryIdLabel;
    private static Librarian librarian;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText("Name: " + librarian.getFirstName() + " " + librarian.getLastName());
        libraryIdLabel.setText("Library Id: " + librarian.getLibraryId());
        AllBooks.setMember(librarian);
        BorrowedBooks.setMember(librarian);
    }

    public static void setLibrarian(Librarian l) {
        librarian = l;
    }

    public void switchToAllBooks(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "AllBooks.fxml");
    }

    public void switchToBorrowedBooks(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "BorrowedBooks.fxml");
    }

    public void showAllMembers(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "AllMembers.fxml");
    }

    public void showAllLibrarians(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "AllLibrarians.fxml");
    }

    public void librarianSignUpScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianSignUpScene.fxml");
    }

    public void switchToLibrarianSignInScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianSignInScene.fxml");
    }

    public void switchToAddBook(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "AddBook.fxml");
    }

    public void switchToRemoveBook(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "RemoveBook.fxml");
    }

    public void switchToBorrowedInformation(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "BorrowedInformation.fxml");
    }
}
