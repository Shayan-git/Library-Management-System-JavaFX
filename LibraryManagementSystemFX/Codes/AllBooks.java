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

public class AllBooks implements Initializable {
    @FXML
    private ListView<Book> allBooksListView;
    private static Member member;

    public static void setMember(Member m) {
        member = m;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Book book : Book.getAllBooksList())
            allBooksListView.getItems().add(book);

        allBooksListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Book> observableValue, Book book, Book t1) {
                allBooksListView.setOnMouseClicked(e -> {
                    Book selectedBook = allBooksListView.getSelectionModel().getSelectedItem();
                    Alert alert;
                    if (selectedBook.isAvailable()) {
                        alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Selected Book");
                        alert.setHeaderText(selectedBook.toString());
                        alert.setContentText("Do you want to borrow this book?");

                        if (alert.showAndWait().get() == ButtonType.OK) {
                            Borrow.borrowBook(member, Book.getAllBooksList(), selectedBook);

                            Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
                            alertInformation.setTitle("Borrowed");
                            alertInformation.setHeaderText(selectedBook.getName() + "  " + selectedBook.getIsbn());
                            alertInformation.setContentText("Now you are having this book!");
                            alertInformation.show();
                        }
                    }
                    else {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Selected Book");
                        alert.setHeaderText(selectedBook.toString());
                        alert.setContentText("This book is not available!");
                        alert.show();
                    }
                });
            }
        });
    }

    public void switchToAllBooks(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "AllBooks.fxml");
    }

    public void switchToItemsScene(ActionEvent event) throws IOException {
        if (member instanceof Librarian)
            ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
        else
            ChangeScene.changeScene(event, "MemberItemsScene.fxml");
    }
}
