import java.io.IOException;
import java.net.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            DatagramSocket client = new DatagramSocket();

            byte[] sendData = "q".getBytes();
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(
                    sendData, 0, sendData.length, address, 5501);
            client.send(sendPacket);

            byte[] reciveData = new byte[1024];
            DatagramPacket recivePacket = new DatagramPacket(reciveData, reciveData.length);
            client.receive(recivePacket);

            String message = new String(recivePacket.getData());
            System.out.println("wiadomosć od serwera " + message);

            client.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}