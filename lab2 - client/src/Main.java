import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Socket clientSocket = new Socket("localhost", 5051);
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()), true);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("można wykonać komunikację ");
            Scanner scanner = new Scanner(System.in);
            String line = null;
            while (true){
                line = scanner.nextLine();
                writer.println(line);
//                writer.flush();
                if (line.trim().equals("q")){
                    System.out.println(reader.readLine());
                    break;
                }
                System.out.println(reader.readLine());
            }

            System.out.println("Zakończenie połaćzenia");
            reader.close();
            writer.close();
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}