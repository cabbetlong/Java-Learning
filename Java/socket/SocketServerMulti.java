import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class SocketServerMulti {
    public static void main (String []args) throws Exception {
        int port = 6666;
        ServerSocket server = new ServerSocket(port);
        String encode = "utf-8";

        // 创建线程池
        ExecutorService exec = Executors.newCachedThreadPool();

        SingleSocket.sockets = new CopyOnWriteArrayList<Socket>();

        while (true) {
            // 等待客户端连接
            Socket socket = server.accept();
            exec.execute(new SingleSocket(socket, encode));
        }
    }
}

class SingleSocket implements Runnable {
    public static CopyOnWriteArrayList<Socket> sockets;

    private String encode;
    private Socket socket;
    private String clientName;

    public SingleSocket (Socket socket, String encode) {
        this.socket = socket;
        this.encode = encode;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), encode));

            this.clientName = reader.readLine();
            if (this.clientName.contains("receive")) {
                sockets.add(this.socket);
            }

            String strFromClient;
            while (true) {
                strFromClient = reader.readLine();

                String msg = this.clientName + " >> " + strFromClient;
                for (Socket s : sockets) {
                    if (s.equals(this.socket)) {
                        continue;
                    }
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), encode));
                    writer.write(msg + "\r\n");
                    writer.flush();
                }

                if (strFromClient.equals("exit")) {
                    System.out.println("[System Info] " + this.clientName + " has left.");
                    break;
                }
                System.out.println(msg);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}