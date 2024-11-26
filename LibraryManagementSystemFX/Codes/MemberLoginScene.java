import javafx.event.ActionEvent;

import java.io.IOException;

public class MemberLoginScene {
    public void switchToMemberSignInScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "MemberSignInScene.fxml");
    }

    public void switchToMemberSignUpScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "MemberSignUpScene.fxml");
    }

    public void switchToLibraryScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibraryScene.fxml");
    }
}
