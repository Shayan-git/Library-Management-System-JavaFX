import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RemoveBook {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField isbnField;
    @FXML
    private Label errorLabel;

    public void removeBookFromLibrary(ActionEvent event) throws IOException {
        boolean key = false;
        String name = nameTextField.getText();
        String isbn = isbnField.getText();

        if (name.length() == 0 || isbn.length() == 0 || Book.getAllBooksList().size() == 0) {
            errorLabel.setText("Invalid or does not exist!");
            return;
        }
        else
            errorLabel.setText("");

        for (int i = 0; i < Book.getAllBooksList().size(); i++) {
            Book book = Book.getAllBooksList().get(i);
            if (name.equals(book.getName()) && isbn.equals(book.getIsbn())) {
                Book.removeBook(book);
                key = true;
                break;
            }
        }

        if (key) {
            errorLabel.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Removed");
            alert.setHeaderText("This book is removed from library!");
            alert.show();
        }
        else
            errorLabel.setText("Invalid or does not exist!");
    }

    public void switchToLibrarianItemsScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
    }
}
