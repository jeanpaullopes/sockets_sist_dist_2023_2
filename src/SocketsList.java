import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketsList {
    private static SocketsList instance;
    private List<Socket> sockets;
    private SocketsList() {
        sockets = new ArrayList<>();
    }
    public static SocketsList getInstance() {
        if (instance == null) {
            instance = new SocketsList();
        }
        return instance;
    }

    public void addSocket(Socket sckt) {
        sockets.add(sckt);
    }
    public boolean removeSocket(Socket sckt) {
        return sockets.remove(sckt);
    }

    // não se deve retornar a lista do objeto
    // de forma direta. Deve-se envar uma cópia
    public List<Socket> getSockets() {
        return sockets;
    }

    public String getListaSockets() {
        String ret = "";
        for (Socket sckt: sockets) {
            ret+= sckt.getInetAddress()+"\n";
        }
        
        return ret;
    }
}
