import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddBook {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField isbnField;
    @FXML
    private Label errorLabel;

    public void addBookToLibrary(ActionEvent event) throws IOException {
        boolean key = false;
        String name = nameTextField.getText();
        String isbn = isbnField.getText();

        if (name.length() == 0 || isbn.length() == 0) {
            errorLabel.setText("Invalid or taken!");
            return;
        }
        else
            errorLabel.setText("");

        for (Book book : Book.getAllBooksList()) {
            if (isbn.equals(book.getIsbn())) {
                key = true;
                break;
            }
        }

        if (key)
            errorLabel.setText("Invalid or taken!");
        else {
            Book.addBook(new Book(name, isbn, true));

            errorLabel.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Added");
            alert.setHeaderText("This book is added to library!");
            alert.show();
        }
    }

    public void switchToLibrarianItemsScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
    }
}
