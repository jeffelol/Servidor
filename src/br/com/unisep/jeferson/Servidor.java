package br.com.unisep.jeferson;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor implements Runnable{
    
    @Override
    public void run() {
        try {
            System.out.println("Esperando conexões...");
            ServerSocket servidor = new ServerSocket(4444);
            InputStream entrada;
            OutputStream saida;
            BufferedReader read;
            PrintStream ps;
            String msgCliente;
            Socket socket;

            while (true) {
                socket = servidor.accept();
                System.out.println("Conexão estabelecida.");

                System.out.println("Endereço do cliente conectado: " + socket.getRemoteSocketAddress());
                
                entrada = socket.getInputStream();
                read = new BufferedReader(new InputStreamReader(entrada));
                
                saida = socket.getOutputStream();
                ps = new PrintStream(saida);
                
                msgCliente = read.readLine();           

                HashMap<String, List> mensagens = new HashMap<>();
                
                if ("MSG".equals(msgCliente)){
                    String json = read.readLine();
                    Gson gson = new Gson();
                    
                    Mensagem ms = gson.fromJson(json, Mensagem.class);
                    ps.println("Enviado mensagem para: " + ms.getDestino());
                }
                
                read.close();
                entrada.close();
                socket.close();

                System.out.println("Esperando nova conexão.");
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
