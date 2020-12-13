package lesson7and8;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {
    public TextField loginRegTF;
    public PasswordField passworRegdPF;
    public PasswordField passwordRepeatPF;
    public Button registration;

    private MockAuthServiceImpl mockAuthService;


    public void registration(ActionEvent actionEvent) {

        mockAuthService= MockAuthServiceImpl.getSample();
        if (mockAuthService.getUserDao().containsKey(loginRegTF.getText())){
            loginRegTF.setText("Wrong: username is already taken");
            passworRegdPF.clear();
            passwordRepeatPF.clear();

        }
        else if (passworRegdPF.getText().equals(passwordRepeatPF.getText())) {
            MockAuthServiceImpl.getSample().addUser(loginRegTF.getText(), passworRegdPF.getText());
            loginRegTF.getScene().getWindow().hide();

        }
        else {
            loginRegTF.setText("Wrong: different password");
            passworRegdPF.clear();
            passwordRepeatPF.clear();
        }

    }
}
