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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.sql.SQLException;
@Component
public class LogInChatController {
    public TextField loginTF;
    public PasswordField passwordPF;
    public Button logInBt;
    public Button registrationBt;

    private static String userName;


    public void enter(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
       userName = loginTF.getText();
       NetworkService.getInstance().write(Message.of(userName,
                String.join(" ", "/$login", loginTF.getText(), passwordPF.getText())));

        Message message =(Message) NetworkService.getInstance().getObjectInputStream().readObject();
        System.out.println(message.toString());


        if (message.getMessage().equals("/$trueLogin")){
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
