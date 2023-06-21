import java.net.*;
import java.io.IOException;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) throws IOException {

        byte[] sendBuffer = new byte[1024];
        byte[] receiveBuffer = new byte[1024];
        int portNumber = 7777;
        DatagramSocket socket = new DatagramSocket(portNumber);
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket);
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getLocalHost(),portNumber);
        socket.send(sendPacket);
        socket.close();

        System.out.println(sendBuffer.toString().getBytes());
        System.out.println(receiveBuffer.toString().getBytes());

    }
}