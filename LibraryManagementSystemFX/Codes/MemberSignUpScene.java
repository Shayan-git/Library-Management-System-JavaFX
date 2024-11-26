import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class MemberSignUpScene {
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

        for (Member member : Member.getMemberList()) {
            if (libraryId.equals(member.getLibraryId())) {
                key = true;
                break;
            }
        }

        if (key)
            errorLabel.setText("Invalid or taken!");
        else {
            Member.getMemberList().add(new Member(firstName, lastName, libraryId, password));

            errorLabel.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Welcome");
            alert.setHeaderText("Welcome to library!");
            if (alert.showAndWait().isPresent())
                ChangeScene.changeScene(event, "MemberLoginScene.fxml");
            else
                ChangeScene.changeScene(event, "MemberLoginScene.fxml");
        }
    }

    public void switchToMemberLoginScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "MemberLoginScene.fxml");
    }
}
