import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeScene {
    private static Parent root;
    private static Stage stage;
    private static Scene scene;

    public static void changeScene(ActionEvent event, String fxmlName) throws IOException {
        root = FXMLLoader.load(ChangeScene.class.getResource(fxmlName));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        String css = ChangeScene.class.getResource("Buttons.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }
}
