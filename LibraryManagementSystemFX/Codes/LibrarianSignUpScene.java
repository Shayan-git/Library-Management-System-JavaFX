import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LibrarianSignUpScene {
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField libraryIdTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Label errorLabel;

    public void signUpMemberCheck(ActionEvent event) throws IOException {
        boolean key = false;
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String libraryId = libraryIdTextField.getText();
        String password = passwordPasswordField.getText();

        if (firstName.length() == 0 || lastName.length() == 0 || libraryId.length() == 0 || password.length() == 0) {
            errorLabel.setText("Invalid or taken!");
            return;
        }
        else
            errorLabel.setText("");

        for (Librarian librarian : Librarian.getLibrarianList()) {
            if (libraryId.equals(librarian.getLibraryId())) {
                key = true;
                break;
            }
        }

        if (key)
            errorLabel.setText("Invalid or taken!");
        else {
            Librarian.getLibrarianList().add(new Librarian(firstName, lastName, libraryId, password));

            errorLabel.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Welcome");
            alert.setHeaderText("Welcome to library!");
            if (alert.showAndWait().isPresent())
                ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
            else
                ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
        }
    }

    public void switchToLibrarianItemsScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
    }
}
