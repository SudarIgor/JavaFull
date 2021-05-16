package chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.Message;

import java.io.IOException;
import java.sql.SQLException;
@Component
public class LogInChatController {
    public TextField loginTF;
    public PasswordField passwordPF;
    public Button logInBt;
    public Button registrationBt;

    private static String userName;

    private NetworkService networkService;
    private FXMLLoaderProvider fxmlLoaderProvider;


    public void enter(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        userName = loginTF.getText();

        networkService.write(Message.of(userName,
                String.join(" ", "/$login", loginTF.getText(), passwordPF.getText())));

        Message message =(Message) networkService.getObjectInputStream().readObject();
        System.out.println(message.toString());


        if (message.getMessage().equals("/$trueLogin")){
            FXMLLoader loader = fxmlLoaderProvider.getLoader("chatForm.fxml");
            Parent chat = loader.load();
//             Parent chat = FXMLLoader.load(getClass().getResource("chatForm.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Chat");
            stage.setScene( new Scene(chat));
            stage.setResizable(false);
            stage.show();
            loginTF.getScene().getWindow().hide();

        }else {
            loginTF.setText("Wrong in login or password");
            passwordPF.clear();
        }
    }

    public void registration(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = fxmlLoaderProvider.getLoader("registration.fxml");
        Parent reg = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Registration");
        stage.setScene( new Scene(reg));
        stage.setResizable(false);
        stage.show();
    }

    public static String getUserName() {

        return userName;
    }

    @Autowired
    public void setNetworkService(NetworkService networkService) {
        this.networkService = networkService;
    }

    @Autowired

    public void setFxmlLoaderProvider(FXMLLoaderProvider fxmlLoaderProvider) {
        this.fxmlLoaderProvider = fxmlLoaderProvider;
    }
}
