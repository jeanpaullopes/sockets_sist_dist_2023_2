import java.io.IOException;
import java.net.Socket;

public class Client {
    static Socket sckt;

    public static void run() {
        try {
            sckt = new Socket("localhost", 4444);
            sckt.getOutputStream()
                    .write("Olá mundo aí!".getBytes());
            sckt.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client.run();
    }
}
