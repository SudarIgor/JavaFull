package chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lesson2.AuthServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class LogInChatController {
    public TextField loginTF;
    public PasswordField passwordPF;
    public Button logInBt;
    public Button registrationBt;

    private static String userName;
    private AuthServiceImpl authService;



    public void enter(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        authService = AuthServiceImpl.getSample();
        boolean auth = authService.auth(loginTF.getText(), passwordPF.getText());

        if (auth){
            userName = authService
                    .getUserDao()
                    .getUserName(authService.getUserDao().getUserByLogin(loginTF.getText()));

            Parent chat = FXMLLoader.load(getClass().getResource("chatForm.fxml"));
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
        Parent reg = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Registration");
        stage.setScene( new Scene(reg));
        stage.setResizable(false);
        stage.show();
    }

    public static String getUserName() {

        return userName;
    }
}
