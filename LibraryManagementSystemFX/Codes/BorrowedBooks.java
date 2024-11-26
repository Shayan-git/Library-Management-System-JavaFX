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

public class BorrowedBooks implements Initializable {
    @FXML
    private ListView<Book> borrowedBooksListView;
    private static Member member;

    public static void setMember(Member m) {
        member = m;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < Borrow.booksOfAMember(member).size(); i++) {
            Book book = Borrow.booksOfAMember(member).get(i);
            borrowedBooksListView.getItems().add(book);
        }

        borrowedBooksListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Book> observableValue, Book book, Book t1) {
                borrowedBooksListView.setOnMouseClicked(e -> {
                    Book selectedBook = borrowedBooksListView.getSelectionModel().getSelectedItem();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Selected Book");
                    alert.setHeaderText(selectedBook.getName() + "  " + selectedBook.getIsbn());
                    alert.setContentText("Do you want to borrow back this book?");

                    if (alert.showAndWait().get() == ButtonType.OK) {
                        Borrow.borrowBackBook(member, selectedBook);

                        borrowedBooksListView.getItems().remove(selectedBook);

                        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
                        alertInformation.setTitle("Borrowed Back");
                        alertInformation.setHeaderText(selectedBook.getName() + "  " + selectedBook.getIsbn());
                        alertInformation.setContentText("Now you are not having this book!");
                        alertInformation.show();
                    }
                });
            }
        });
    }

    public void switchToBorrowedBooks(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "BorrowedBooks.fxml");
    }

    public void switchToItemsScene(ActionEvent event) throws IOException {
        if (member instanceof Librarian)
            ChangeScene.changeScene(event, "LibrarianItemsScene.fxml");
        else
            ChangeScene.changeScene(event, "MemberItemsScene.fxml");
    }
}
