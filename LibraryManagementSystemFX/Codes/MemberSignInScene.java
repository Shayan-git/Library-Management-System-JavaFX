import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MemberSignInScene {
    @FXML
    private TextField libraryIdTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Label errorLabel;

    public void signInMemberCheck(ActionEvent event) throws IOException {
        boolean key = false;
        String libraryId = libraryIdTextField.getText();
        String password = passwordPasswordField.getText();

        if (libraryId.length() == 0 || password.length() == 0 || Member.getMemberList().size() == 0) {
            errorLabel.setText("Invalid or does not exist!");
            return;
        }
        else
            errorLabel.setText("");

        for (Member member : Member.getMemberList()) {
            if (libraryId.equals(member.getLibraryId()) && password.equals(member.getPassword())) {
                MemberItemsScene.setMember(member);
                key = true;
                break;
            }
        }

        if (key)
            ChangeScene.changeScene(event, "MemberItemsScene.fxml");
        else
            errorLabel.setText("Invalid or does not exist!");
    }

    public void switchToMemberLoginScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "MemberLoginScene.fxml");
    }
}
