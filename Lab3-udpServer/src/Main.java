import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            DatagramSocket server = new DatagramSocket(5501);

            byte[] reciveData = new byte[1024];
            System.out.println("oczekuje na połaćżenia ...");
            DatagramPacket recivePacket = new DatagramPacket(reciveData, reciveData.length);
            while (true){
                reciveData = new byte[1024];
                server.receive(recivePacket);

                String message = new String(recivePacket.getData());
                System.out.println(" wiadomość od klienta " + message);

                SocketAddress address = recivePacket.getSocketAddress();
                byte[] sendData = message.toUpperCase().getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address);
                server.send(sendPacket);
                if(message.trim().equals("q")){
                    break;
                }
            }
            System.out.println("zakończenie działąnia aplikacji serwerowej");

            server.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}