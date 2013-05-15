
package br.com.unisep.jeferson;

public class AppServidor {
    public static void main(String[] args) {

        while (true) {
            Servidor ser = new Servidor();
            ser.run();
        }
    }
}
