package serverSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketClass {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            while(true){
                Socket socket = serverSocket.accept();
                new Thread(new MyServerRun(socket)).start();
            }
        }
    }
}

class MyServerRun implements Runnable{
    Socket socket;

    public MyServerRun(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(Scanner scanner = new Scanner(socket.getInputStream())){
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            String line = scanner.nextLine();
            while (line!=null&&!line.isEmpty()){
                System.out.println(line);
                line = scanner.nextLine();
            }

//            if (scanner.hasNextLine()){
////                writer.println("Hello " + scanner.nextLine());
//                System.out.println(line);
//                line = scanner.nextLine();
//            }

            String info = scanner.nextLine();
            OutputStream ouptput = socket.getOutputStream();
            ouptput.write(info.toString().getBytes("UTF-8"));
            ouptput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
