package chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ChatApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        FXMLLoader loader = context.getBean(FXMLLoaderProvider.class).getLoader("logInChat.fxml");
        Parent logInChat = loader.load();

        primaryStage.setTitle("Authorization");
        primaryStage.setScene(new Scene(logInChat));
        primaryStage.setResizable(false);
        primaryStage.show();

    }



}
