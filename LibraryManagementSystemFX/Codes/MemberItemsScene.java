import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberItemsScene implements Initializable {
    @FXML
    private Label nameLabel;
    @FXML
    private Label libraryIdLabel;
    private static Member member;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText("Name: " + member.getFirstName() + " " + member.getLastName());
        libraryIdLabel.setText("Library Id: " + member.getLibraryId());
        AllBooks.setMember(member);
        BorrowedBooks.setMember(member);
    }

    public static void setMember(Member m) {
        member = m;
    }

    public void switchToAllBooks(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "AllBooks.fxml");
    }

    public void switchToBorrowedBooks(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "BorrowedBooks.fxml");
    }

    public void switchToMemberSignInScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "MemberSignInScene.fxml");
    }
}
