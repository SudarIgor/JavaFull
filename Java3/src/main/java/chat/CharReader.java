package chat;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;

public class CharReader extends Thread {

    private final TextArea out;
    private final ObjectInputStream is;
    private final TextField clentName;
    private boolean running;

    public CharReader(TextField clentName, TextArea out, ObjectInputStream is) {
        this.out = out;
        this.is = is;
        running = true;
        this.clentName = clentName;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Message message = (Message) is.readObject();
                out.appendText(message.toString());
                clentName.clear();
                clentName.appendText(message.getAuthor());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}