import java.io.*;
import java.net.*;

public class UpperClient {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader kb = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connected. Type a message (or 'exit'):");
            String msg;
            while ((msg = kb.readLine()) != null && !msg.equalsIgnoreCase("exit")) {
                out.println(msg);
                System.out.println("Server replied: " + in.readLine());
            }
        }
    }
}