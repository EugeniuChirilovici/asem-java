package WebServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Listening for connection on port 8189 ...");
            while (true){
                Socket socket = serverSocket.accept();
                    new Thread(new WebServer(socket)).start();
            }
    }
}
