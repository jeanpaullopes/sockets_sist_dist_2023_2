import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketsList {
    private static SocketsList instance;
    private List<Socket> sockets;
    private Map<String, Socket> socketsMap;
    private SocketsList() {
        sockets = new ArrayList<>();
        socketsMap = new HashMap<>();
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
    public void addSocket(String nome, Socket sckt) {
        socketsMap.put(nome, sckt);
    }
    public Socket removeSocket(String nome) {
        return socketsMap.remove(nome);
    }
    public boolean removeSocket(Socket sckt) {
        return sockets.remove(sckt);
    }

    // não se deve retornar a lista do objeto
    // de forma direta. Deve-se envar uma cópia
    public List<Socket> getSockets() {
        ArrayList<Socket> list = new ArrayList<>(socketsMap.values());
        return list;

    }

    public String getListaSockets() {
        String ret = "";
        for (Socket sckt: getSockets()) {
            ret+= sckt.getInetAddress()+"\n";
        }

        return ret;
    }
}
