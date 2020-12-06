package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8189);
            System.out.println("Connected to Server");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread writeThread = new Thread(() -> {
                try {
                    Scanner sc = new Scanner(System.in);
                    while (sc.hasNextLine()) {
                        String msg = sc.nextLine();
                        out.writeUTF(msg);
                        out.flush();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            });

            Thread readThread = new Thread(() -> {
                try {
                    while (true) {
                        String mes = in.readUTF();
                        System.out.println("Message from server: " + mes);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            writeThread.setDaemon(true);
            writeThread.start();
            readThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
