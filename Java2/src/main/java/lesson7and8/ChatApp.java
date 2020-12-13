package lesson7and8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ChatApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent logInChat = FXMLLoader.load(getClass().getResource("logInChat.fxml"));
        primaryStage.setTitle("Authorization");
        primaryStage.setScene(new Scene(logInChat));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


}
