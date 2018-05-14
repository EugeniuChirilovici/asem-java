package WebServerSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class WebServer implements Runnable{
    Socket socket;

    public WebServer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
            try {
                System.out.println("Connection, sending data.");
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = in.readLine();
                while (str!=null&&!str.isEmpty()) {
                    System.out.println(str);
                    str = in.readLine();
                }

                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter additional information ...");
                String serverAdd = input.readLine();

                OutputStream ouptput = socket.getOutputStream();
                String info = null;
                info = "HTTP/1.0 200 OK\r\n\r\n <html><body></html></body>" + "<h2>" + serverAdd + "</h2>" +
                        "</body></html>";
                ouptput.write(info.getBytes("UTF-8"));
                ouptput.close();
                socket.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
    }
}
