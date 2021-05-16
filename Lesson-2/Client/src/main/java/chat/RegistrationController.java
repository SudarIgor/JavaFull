package chat;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.Message;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;
@Component
public class RegistrationController implements Closeable {
    public TextField loginRegTF;
    public PasswordField passworRegdPF;
    public PasswordField passwordRepeatPF;
    public Button registration;

    private NetworkService networkService;


    public void registration(ActionEvent actionEvent)  throws SQLException, ClassNotFoundException, IOException {


        if (passworRegdPF.getText().equals(passwordRepeatPF.getText())) {
            networkService.write(Message.of("User",
                    String.join(" ", "/$registration", loginRegTF.getText(), passworRegdPF.getText())));
            Message message = (Message) networkService.getObjectInputStream().readObject();
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

    @Autowired
    public void setNetworkService(NetworkService networkService) {
        this.networkService = networkService;
    }
}
