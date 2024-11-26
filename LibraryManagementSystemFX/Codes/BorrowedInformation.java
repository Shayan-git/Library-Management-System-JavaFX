import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BorrowedInformation implements Initializable {
    @FXML
    private ListView<Borrow> allPeapleBorrowedListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Borrow borrow : Borrow.getAllPeopleWhoBorrowed())
            allPeapleBorrowedListView.getItems().add(borrow);
    }

    public void switchToBorrowedInformation(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "BorrowedInformation.fxml");
    }

    public void switchToLibrarianItemsScene(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
    }
}
