import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LibrarianSignInScene {
    @FXML
    private TextField libraryIdTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Label errorLabel;

    public void signInMemberCheck(ActionEvent event) throws IOException {
//        * * * * * * * * * * * *
        if (Librarian.getLibrarianList().size() == 0)
            Librarian.getLibrarianList().add(new Librarian("l", "l", "l", "l"));
//        * * * * * * * * * * * *

        boolean key = false;
        String libraryId = libraryIdTextField.getText();
        String password = passwordPasswordField.getText();

        if (libraryId.length() == 0 || password.length() == 0 || Librarian.getLibrarianList().size() == 0) {
            errorLabel.setText("Invalid or does not exist!");
            return;
        }
        else
            errorLabel.setText("");

        for (Librarian librarian : Librarian.getLibrarianList()) {
            if (libraryId.equals(librarian.getLibraryId()) && password.equals(librarian.getPassword())) {
                LibrarianItemsScene.setLibrarian(librarian);
                key = true;
                break;
            }
        }

        if (key)
            ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
        else
            errorLabel.setText("Invalid or does not exist!");
    }

    public void switchToMemberLoginScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianLoginScene.fxml");
    }
}
