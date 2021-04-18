package chat;

import lesson2.AuthServiceHandler;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

public class SerialHandler implements Closeable, Runnable {

    private static int cnt = 0;
    private String userName;
    private final ObjectInputStream is;
    private final ObjectOutputStream os;
    private boolean running;
    private final byte [] buffer;
    private final Server server;
    private AuthServiceHandler authServiceHandler;


    public SerialHandler(Socket socket, Server server) throws IOException {
        os = new ObjectOutputStream(socket.getOutputStream());
        is = new ObjectInputStream(socket.getInputStream());
        cnt++;
        userName = "user#" + cnt;
        running = true;
        buffer = new byte[256];
        this.server = server;
        os.writeObject(Message.of("Server", "Connection to the server is successful"));
        os.flush();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Message message = (Message) is.readObject();
                if(message.getMessage().startsWith("/$start")){
                    userName = message.getAuthor();
                    continue;
                }
                if (message.getMessage().startsWith("/changeNick")) {
                    authServiceHandler = new AuthServiceHandler();
                    String[] data = message.getMessage().split(" ");
                    String oldName = userName;
                    userName = data[1];

                    String msg = String.format("User %s change name to: %s", oldName, userName);
                    message.setAuthor(userName);
                    message.setMessage(msg);
                    System.out.println(message);
                    server.broadCast(message);
                    continue;
                }
                if (message.getMessage().startsWith("/private")) {
                    String[] data = message.getMessage().split(" ");
                    String nick = data[1];
                    String msg = data[2];
                    sendMessage(message);
                    server.sendMessageTo(userName, nick, msg);
                    continue;
                }
                message.setAuthor(userName);
                System.out.println(message);
                server.broadCast(message);
            } catch (IOException | ClassNotFoundException | SQLException e) {
                System.err.println("Exception while read");
                break;
            }
        }
    }

    public void sendMessage(Message message) throws IOException {
        os.writeObject(message);
        os.flush();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void close() throws IOException {
        os.close();
        is.close();
    }
}