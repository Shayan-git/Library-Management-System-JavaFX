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

public class AllMembers implements Initializable {
    @FXML
    private ListView<Member> allMembersListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Member member : Member.getMemberList())
            allMembersListView.getItems().add(member);

        allMembersListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Member> observableValue, Member member, Member t1) {
                allMembersListView.setOnMouseClicked(e -> {
                    Member selectedMember = allMembersListView.getSelectionModel().getSelectedItem();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Selected Member");
                    alert.setHeaderText(selectedMember.toString());
                    alert.setContentText("Do you want to remove this member?");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        Member.removeMember(selectedMember);
                    }
                });
            }
        });
    }

    public void switchToAllMembers(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "AllMembers.fxml");
    }

    public void switchToLibrarianItemsScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
    }
}
