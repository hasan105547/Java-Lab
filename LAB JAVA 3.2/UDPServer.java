import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5000);
        System.out.println("UDP Server listening on port 5000...");
        byte[] buf = new byte[1024];
        while (true) {
            DatagramPacket in = new DatagramPacket(buf, buf.length);
            socket.receive(in);
            String msg = new String(in.getData(), 0, in.getLength());
            System.out.println("Received: " + msg);
            Thread.sleep(6);                               // wait 6 ms
            byte[] reply = msg.toUpperCase().getBytes();
            socket.send(new DatagramPacket(reply, reply.length, in.getAddress(), in.getPort()));
        }
    }
}