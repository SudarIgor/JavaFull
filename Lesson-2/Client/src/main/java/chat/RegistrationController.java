package chat;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import server.Message;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationController implements Closeable {
    public TextField loginRegTF;
    public PasswordField passworRegdPF;
    public PasswordField passwordRepeatPF;
    public Button registration;


    public void registration(ActionEvent actionEvent)  throws SQLException, ClassNotFoundException, IOException {


        if (passworRegdPF.getText().equals(passwordRepeatPF.getText())) {
            NetworkService.getInstance().write(Message.of("User",
                    String.join(" ", "/$registration", loginRegTF.getText(), passworRegdPF.getText())));
            Message message = (Message) NetworkService.getInstance().getObjectInputStream().readObject();
            if (message.getMessage().equals("/$registrationSuccessful")) {
                loginRegTF.setText("Registration successful");
                passworRegdPF.clear();
                passwordRepeatPF.clear();
            } else {
                loginRegTF.setText("Wrong: username is already taken");
                passworRegdPF.clear();
                passwordRepeatPF.clear();
            }
        }
    }

    @Override
    public void close() throws IOException {
        passworRegdPF.getScene().getWindow().hide();
    }
}
