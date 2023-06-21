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

        String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Recevied from the client: " + receivedData);

        String sendData = "Hello, client!";
        sendBuffer = sendData.getBytes();

        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);

        socket.send(sendPacket);
        socket.close();
    }
}