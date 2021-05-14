package chat;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
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
    private AuthServiceImpl authServiceImpl;


    public SerialHandler(Socket socket, Server server) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        os = new ObjectOutputStream(socket.getOutputStream());
        is = new ObjectInputStream(socket.getInputStream());
        cnt++;
        userName = "user#" + cnt;
        running = true;
        buffer = new byte[256];
        this.server = server;
        authServiceImpl = context.getBean("authServiceImpl",AuthServiceImpl.class);
        authServiceHandler = context.getBean("authServiceHandler", AuthServiceHandler.class);
//        os.writeObject(Message.of("Server", "Connection to the server is successful"));
//        os.flush();
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
                if(message.getMessage().startsWith("/$login")){
                    System.out.println("in login");
                    boolean flag;
                    userName = message.getAuthor();
                    flag = authServiceImpl.auth(
                            message.getMessage().split(" ")[1], message.getMessage().split(" ")[2]);
                    System.out.println(flag);
                    if(flag) {
                        System.out.println("Send true");
                        os.writeObject(Message.of(userName,"/$trueLogin"));
                    }
                    else  {
                        System.out.println("Send false");
                        os.writeObject(Message.of(userName,"/$falseLogin"));
                    }
                    continue;
                }
                if(message.getMessage().startsWith("/$registration")){
//                     authServiceHandler = new AuthServiceHandler();
                     if(!authServiceHandler.userExists(message.getMessage().split(" ")[1])){
                         authServiceImpl.addUser(message.getMessage().split(" ")[1],
                                 message.getMessage().split(" ")[2]);
                         os.writeObject(Message.of("Name", "/$registrationSuccessful"));
                     }   else  os.writeObject(Message.of("Name", "/$loginIsBusy"));

//                    os.writeObject(Message.of("Name","/$trueLogin"));
                    continue;
                }

                if(message.getMessage().startsWith("/$start")){
                    os.writeObject(Message.of("Server", "Connection to the server is successful"));
                    os.flush();

                    continue;
                }
                if (message.getMessage().startsWith("/changeNick")) {
//                    authServiceHandler = new AuthServiceHandler();
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