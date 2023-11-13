import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket sckt;

    public static void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            // cria um socket cliente no endereço `localhost`
            // na porta 4444
            sckt = new Socket("localhost", 4444);
            String msg;
            //não precisa mais de loop
            //do {
                System.out.println("informe seu Nome:");
                msg = scanner.nextLine();
                // pega o outputStream (fluxo de saída do
                // socket e escreve o valor da variável
                //  entrada
                sckt.getOutputStream()
                        .write(msg.getBytes());
                // manda um caracter 255 ASCII para
                // sinalizar o final da transmissão
                // sem fechar o socket
                sckt.getOutputStream().write(255);
                // força o envio de todo o stream de
                // saída
                sckt.getOutputStream().flush();
            //} while (msg.length() > 0);

            // cria um bufferedReader a partir do
            // fluxo de entrada do socket para ler
            // o retorno
            // obs.: não está sendo utilizado no momento
            // trocado pela leitura caracter a caracter
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            sckt.getInputStream()));
            String retorno = "";
            int ret = 0;
            // faz um laço de repetição para a leitura
            // caracter a caracter enquanto o socket estiver
            // aberto
            while(!sckt.isClosed() && ret >= 0){
                // lê um caracter diretamente do fluxo de entrada
                ret = sckt.getInputStream().read();
                // converte o valor de entrada int para
                // char e concatena na variável retorno
                retorno += (char) ret;
                System.out.println(ret);
            }
            System.out.println(retorno);
            // fecha o socket e encerra tudo
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
