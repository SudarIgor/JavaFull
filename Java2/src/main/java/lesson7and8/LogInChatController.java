package lesson7and8;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInChatController {
    public TextField loginTF;
    public PasswordField passwordPF;
    public Button logInBt;
    public Button registrationBt;
    private MockAuthServiceImpl mockAuthService;


    public void enter(ActionEvent actionEvent) throws IOException {

        mockAuthService = MockAuthServiceImpl.getSample();
        boolean auth = mockAuthService.auth(loginTF.getText(), passwordPF.getText());
        if (auth){
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


}
