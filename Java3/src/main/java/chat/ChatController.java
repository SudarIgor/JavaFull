package chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lesson2.AuthServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ChatController implements Initializable {

    public TextArea reedChatTextAr;
    public TextField writeChatTextAr;
    public TextField clentName;
    public Button quitBT;
    private String userName;
    private CharReader reader;

    public void send(ActionEvent actionEvent) throws IOException {
        NetworkService.getInstance()
                .write(Message.of(userName, writeChatTextAr.getText()));
        writeChatTextAr.clear();

        System.out.println(writeChatTextAr.getText());

    }

    public void quit(ActionEvent actionEvent) throws IOException {

        clentName.getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent logInChat = FXMLLoader.load(getClass().getResource("logInChat.fxml"));
        primaryStage.setTitle("Authorization");
        primaryStage.setScene(new Scene(logInChat));
        primaryStage.setResizable(false);
        primaryStage.show();
        reader.setDaemon(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName = LogInChatController.getUserName();
        clentName.clear();
        clentName.appendText(userName);
        reader = new CharReader(reedChatTextAr, NetworkService.getInstance().getInputStream());
        try {
            NetworkService.getInstance()
                    .write(Message.of(userName, "/$start"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.start();
    }


    public void changeName(ActionEvent actionEvent) {

    }
}

