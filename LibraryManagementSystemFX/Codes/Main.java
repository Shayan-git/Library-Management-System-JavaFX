import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryScene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        String css = this.getClass().getResource("Buttons.css").toExternalForm();
        scene.getStylesheets().add(css);

        Image icon = new Image("Library_icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Library");

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
