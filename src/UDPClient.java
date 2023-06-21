import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {

        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer = new byte[1024];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter server IP address: ");
        String host = reader.readLine();

        DatagramSocket socket = new DatagramSocket();

        InetAdress serverAddress = InetAddress.getByName(host);
        int serverPort = 7777;

        String sendData = "Hello, server!";
        sendBuffer = sendData.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
        socket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket);

        String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from server: " + receivedData);


        socket.close();
    }
}
