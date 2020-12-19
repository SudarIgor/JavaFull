package lesson6;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static ClientHandler handler;

    public static void main(String[] args) throws IOException {

        Thread readThread = new Thread(() -> {
            try {
                Scanner sc = new Scanner(System.in);
                while (sc.hasNextLine()) {
                    String msg = sc.nextLine();
                    if (handler == null) {
                        System.out.println("Wait");
                        while (handler == null) {
                            Thread.sleep(250);
                        }
                    }
                    handler.sendMessage(msg);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        readThread.setDaemon(true);
        readThread.start();

        try  {
            ServerSocket server = new ServerSocket(8189);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client is connected");
                handler = new ClientHandler(socket);
                new Thread(handler).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}