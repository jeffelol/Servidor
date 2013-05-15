
package br.com.unisep.jeferson;

import java.util.ArrayList;

public class AppServidor {
    public static void main(String[] args) {
        
        ArrayList servidores = new ArrayList();
        ArrayList threads = new ArrayList();
        
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Servidor());
        }
    }
}
