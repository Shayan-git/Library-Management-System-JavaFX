import javafx.event.ActionEvent;

import java.io.IOException;

public class LibraryScene {
    public void switchToMemberLoginScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "MemberLoginScene.fxml");
    }

    public void switchToLibrarianLoginScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianLoginScene.fxml");
    }
}
