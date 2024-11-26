import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllLibrarians implements Initializable {
    @FXML
    private ListView<Member> allLibrariansListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Librarian librarian : Librarian.getLibrarianList())
            allLibrariansListView.getItems().add(librarian);

        allLibrariansListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Member> observableValue, Member member, Member t1) {
                allLibrariansListView.setOnMouseClicked(e -> {
                    Member selectedMember = allLibrariansListView.getSelectionModel().getSelectedItem();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Selected Librarian");
                    alert.setHeaderText(selectedMember.toString());
                    alert.setContentText("Do you want to remove this librarian?");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        Member.removeLibrarian(selectedMember);
                    }
                });
            }
        });
    }

    public void switchToAllLibrarians(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "AllLibrarians.fxml");
    }

    public void switchToLibrarianItemsScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
    }
}
