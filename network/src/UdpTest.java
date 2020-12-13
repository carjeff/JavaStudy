import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author JeffCar
 * @date 12/7/2020 - 9:44 PM
 */
public class UdpTest {

    //发送端
    @Test
    public void send() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP发送的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 9090);

        socket.send(packet);

        socket.close();
    }

    //接收端
    @Test
    public void receive() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] data = new byte[100];
        DatagramPacket packet = new DatagramPacket(data, 0, data.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();
    }
}
