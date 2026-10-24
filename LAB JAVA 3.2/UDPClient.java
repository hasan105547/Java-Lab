import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type a message (max 1024 bytes):");
        byte[] data = kb.readLine().getBytes();
        socket.send(new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 5000));

        byte[] buf = new byte[1024];
        DatagramPacket reply = new DatagramPacket(buf, buf.length);
        socket.receive(reply);
        System.out.println("Server replied: " + new String(reply.getData(), 0, reply.getLength()));
        socket.close();
    }
}