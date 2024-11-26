import javafx.event.ActionEvent;

import java.io.IOException;

public class LibrarianLoginScene {
    public void switchToLibrarianSignInScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianSignInScene.fxml");
    }

    public void switchToLibraryScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibraryScene.fxml");
    }
}
