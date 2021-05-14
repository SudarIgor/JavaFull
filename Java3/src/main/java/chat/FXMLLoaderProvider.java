package chat;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FXMLLoaderProvider {
    private AnnotationConfigApplicationContext context;


    @Autowired
    public void setContext(AnnotationConfigApplicationContext context) {
        this.context = context;
    }

    public FXMLLoader getLoader (String path){
        FXMLLoader loader =new FXMLLoader();
        loader.setControllerFactory(e -> context.getBean(e));
        loader.setLocation(getClass().getResource(path));
        return loader;
    }
}
