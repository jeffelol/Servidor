
package br.com.unisep.jeferson;

public class AppServidor {
    public static void main(String[] args) {

        Servidor ser = new Servidor();
        Thread t1 = new Thread(ser);
        t1.start();

    }
}
