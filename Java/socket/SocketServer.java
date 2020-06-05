import java.io.*;
import java.net.*;

public class SocketServer {
    public static void main (String []args) throws IOException {
        int port = 6666;
        ServerSocket server = new ServerSocket(port);
        String encode = "utf-8";

        // waiting for client's connection
        Socket socket = server.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), encode));

        String strFromClient;
        while (!(strFromClient = reader.readLine()).equals("exit")) {
            System.out.println("client >> " + strFromClient);
        }
    }
}
