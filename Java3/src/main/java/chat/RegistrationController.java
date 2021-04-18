package chat;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lesson2.AuthServiceHandler;
import lesson2.AuthServiceImpl;

import java.sql.SQLException;

public class RegistrationController {
    public TextField loginRegTF;
    public PasswordField passworRegdPF;
    public PasswordField passwordRepeatPF;
    public Button registration;

    private AuthServiceImpl authService;


    public void registration(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        authService = AuthServiceImpl.getSample();


        if (authService.getUserDao().userExists(loginRegTF.getText())){
            loginRegTF.setText("Wrong: username is already taken");
            passworRegdPF.clear();
            passwordRepeatPF.clear();

        }
        else if (passworRegdPF.getText().equals(passwordRepeatPF.getText())) {
            authService.addUser(loginRegTF.getText(), passworRegdPF.getText());

            loginRegTF.getScene().getWindow().hide();

        }
        else {
            loginRegTF.setText("Wrong: different password");
            passworRegdPF.clear();
            passwordRepeatPF.clear();
        }

    }
}
