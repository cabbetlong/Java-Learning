import java.io.*;
import java.net.*;

public class SocketClient {
    public static void main (String []args) throws Exception {
        System.out.print("Input your name to enter the chat room: ");
        BufferedReader sysIoReader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
        String name = sysIoReader.readLine();

        Thread tSend = new Thread(new SendMessage(name));
        tSend.start();
        Thread tReceive = new Thread(new ReceiveMessage(name));
        tReceive.start();
    }
}

class ReceiveMessage implements Runnable {
    private String name;

    public ReceiveMessage(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            String host = "localhost";
            int port = 6666;
            String encode = "utf-8";

            Socket client = new Socket(host, port);

            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), encode));

            socketWriter.write(this.name + "_receive" + "\r\n");
            socketWriter.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(), encode));
            String strMessage;
            while (true) {
                strMessage = reader.readLine();
                if (strMessage.contains(this.name)) {
                    if (strMessage.contains("exit")) {
                        break;
                    }
                } else {
                    System.out.println(strMessage);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SendMessage implements Runnable {
    private String name;

    private String host = "localhost";
    private int port = 6666;
    private String encode = "utf-8";

    public SendMessage(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Socket client = new Socket(host, port);

            BufferedReader sysIoReader = new BufferedReader(new InputStreamReader(System.in, encode));

            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), encode));

            socketWriter.write(this.name + "\r\n");
            socketWriter.flush();

            String strMessage;
            while (true) {
                strMessage = sysIoReader.readLine();
                socketWriter.write(strMessage + "\r\n");
                socketWriter.flush();

                if (strMessage.equals("exit")) {
                    break;
                }
            }

            socketWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
