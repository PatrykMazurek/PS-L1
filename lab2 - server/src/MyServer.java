import java.io.*;
import java.net.Socket;

public class MyServer implements Runnable{

    private PrintWriter writer;
    private BufferedReader reader;
    private Socket clientSocket;

    public MyServer(Socket s){
        clientSocket = s;
        try {
            writer = new PrintWriter(new OutputStreamWriter(
                    clientSocket.getOutputStream()),true);
            reader = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
            System.out.println("Nawiązano połączenie z " + clientSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        StringBuilder builder = new StringBuilder();
        String line = null;
        while (true){
            try {
                line = reader.readLine();
                System.out.println(line);
                if (line.trim().equals("q")){
                    writer.println("pa pa");
                    break;
                }
                builder.append(line);
                writer.println(builder.reverse());
                builder.delete(0, builder.length());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        disconnect();
    }

    private void disconnect(){
        if (!clientSocket.isClosed()){
            try {
                reader.close();
                writer.close();
                clientSocket.close();
                System.out.println("zakończono połączenie");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

