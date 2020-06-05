import java.io.*;

public class FileStreamDemo {
    public static void main (String []args) throws IOException{
        File f = new File("text.txt");

        FileOutputStream fop = new FileOutputStream(f);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "utf-8");
        writer.append("哈哈哈\r\n");
        writer.append("Laugh loudly\r\n");
        writer.append("没了\r\n");
        writer.close();
        fop.close();

        FileInputStream fip = new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(fip, "utf-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }

        System.out.print(sb.toString());

        reader.close();
        fip.close();
    }
}
