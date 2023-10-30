import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static ServerSocket serverSck;
    static BufferedReader in;

    private static void run() {
        try {
            serverSck = new ServerSocket(4444);
        Socket sckt = serverSck.accept();
        in = new BufferedReader(
                new InputStreamReader(
                        sckt.getInputStream()));
        String entrada = in.readLine();
        System.out.println(entrada);
        sckt.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Server.run();
    }

}
