package serverSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketClass {
    public static void main(String[]args) throws IOException {
        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress("localhost",8189),2000);
            Scanner input = new Scanner(socket.getInputStream());
            while (input.hasNext()){
                System.out.println(input.nextLine());
            }
            input.close();
        }
    }
}
