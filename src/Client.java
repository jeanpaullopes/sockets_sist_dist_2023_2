import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket sckt;

    public static void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            sckt = new Socket("localhost", 4444);
            String msg;
            do {
                System.out.println("informe a mensagem:");
                msg = scanner.nextLine();
                sckt.getOutputStream()
                        .write(msg.getBytes());
                sckt.getOutputStream().flush();
            } while (msg.length() > 0);
            sckt.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client.run();
    }
}
