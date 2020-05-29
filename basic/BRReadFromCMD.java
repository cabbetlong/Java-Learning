import java.io.*;

public class BRReadFromCMD {
    public static void main(String []args) throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input characters, quit when input 'end'.");

        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }
}
