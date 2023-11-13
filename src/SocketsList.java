import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketsList {
    private static SocketsList instance;
    private Map<String, String> socketsMap;
    private SocketsList() {
        socketsMap = new HashMap<>();
    }
    public static SocketsList getInstance() {
        if (instance == null) {
            instance = new SocketsList();
        }
        return instance;
    }

    public void addSocket(String nome, String ip) {
        socketsMap.put(ip, nome);
    }
    public String removeSocket(String nome) {
        return socketsMap.remove(nome);
    }

    // não se deve retornar a lista do objeto
    // de forma direta. Deve-se envar uma cópia
    public List<String> getSockets() {
        ArrayList<String> list = new ArrayList<>(socketsMap.values());
        return list;
    }

    public String getListaSockets() {
        String ret = "";
        for (String nome: getSockets()) {
            ret+= nome+"\n";
        }

        return ret;
    }
}
