package lesson6;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(Socket socket) throws IOException {
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    public void sendMessage(String msg) throws IOException {
        out.writeUTF(msg);
        out.flush();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String mes = in.readUTF();
                System.out.println("Message from client: " + mes);
            } catch (IOException e) {
                System.out.println("Client disconnected");
                break;
            }
        }
    }
}