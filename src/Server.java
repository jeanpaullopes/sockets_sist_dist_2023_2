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
            // cria um servidor de Socket na porta 4444
            serverSck = new ServerSocket(4444);
            System.out.println("Vai aguardar conexao");
            //laó de repetição infinito
            while(true) {
                //aguarda uma conexão na porta 4444
                Socket sckt = serverSck.accept();
                //quando ocorrer uma conexão, cria um objeto
                // SocketThread para acompanhar a conexão e
                // a comunicação
                SocketThread minhaThread = new SocketThread(sckt);
    //            SocketsList.getInstance().addSocket("nome", sckt);
                // inicia a Thread
                minhaThread.start();
                // retorna a aguardar outra conexão
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Server.run();
    }

}
