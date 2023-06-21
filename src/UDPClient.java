import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClient {

    public static void main(String[] args) throws IOException {

        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer = new byte[1024];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String host = reader.readLine();
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(host), 7777);
        socket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket);
        socket.close();
        System.out.println(receivePacket);
    }
}
