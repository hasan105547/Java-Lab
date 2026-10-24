import java.io.*;
import java.net.*;

public class UpperServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server listening on port 5000...");
            try (Socket s = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                 PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {
                System.out.println("Client connected.");
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Received: " + msg);
                    out.println(msg.toUpperCase());
                }
                System.out.println("Client disconnected.");
            }
        }
    }
}