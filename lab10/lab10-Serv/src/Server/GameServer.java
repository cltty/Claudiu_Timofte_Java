package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;

    public static void main(String[] args)  {
        GameServer server = new GameServer();
        try {
            serverSocket = new ServerSocket( PORT );
        } catch (IOException e) {
            e.printStackTrace();
        }
        running = true;
        while (true) {
            System.out.println("Waiting for a client..");
            try {
                Socket socket = serverSocket.accept();
                new ClientThread(socket,this).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
