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
            System.out.println("Vai aguardar conexao");
            while(true) {
                Socket sckt = serverSck.accept();
                new SocketThread(sckt).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Server.run();
    }

}
