import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketThread extends Thread{
    Socket socket;
    BufferedReader in;
    public SocketThread(Socket sckt) {
        this.socket = sckt;
    }
    public void run() {
        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));
            String entrada = "";
            int ret = 0;
            System.out.println("conexao de "+
            socket.getRemoteSocketAddress().toString());
            while(!socket.isClosed() && ret >= 0){
                ret = socket.getInputStream().read();
                entrada += (char) ret;

            }
            System.out.println(ret+ "  "+entrada);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
