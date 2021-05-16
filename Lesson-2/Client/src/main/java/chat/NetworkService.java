package chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.Message;

import java.io.*;
import java.net.Socket;
@Component
public class NetworkService {
    private static NetworkService instance;
    private final ObjectInputStream is;
    private final ObjectOutputStream os;

    public NetworkService() {
        try {
            Socket socket = new Socket("localhost", 8189);
            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException("Couldn't create network connection");
        }
    }


//    public static NetworkService getInstance(){
//        if (instance == null){
//            instance = new NetworkService();
//        }
//        return instance;
//    }


    public void write(Message message) throws IOException {
        os.writeObject(message);
        os.flush();
    }

    public ObjectInputStream getObjectInputStream() {
        return is;
    }

    public String getUserName() {
        try {
            return ((Message) is.readObject()).getAuthor();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
