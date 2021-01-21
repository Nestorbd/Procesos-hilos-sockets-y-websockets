/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maqui
 */
public class AttendToClient extends Thread {

    Socket socket;

    public AttendToClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        talkToClient(socket);
    }

    private static void talkToClient(Socket socket) {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            Hand g1;
            Hand g2;
            String result;

            do {
                int lineFromClient = br.read();
                System.out.println(lineFromClient);
                switch (lineFromClient) {
                    case 1:
                        g1 = Hand.stone;
                        g2 = Random();

                        if (g2 == Hand.stone) {
                            bw.write("EL jugador 2 ha elegido piedra. ");
                            
                        } else if (g2 == Hand.paper) {
                            bw.write("EL jugador 2 ha elegido papel. ");
                            
                        } else {
                            bw.write("EL jugador 2 ha elegido tijeras. ");
                           
                        }

                        result = Game(g1, g2);
                        System.out.println(result);
                        bw.write(result);
                        bw.newLine();
                        bw.flush();
                        break;
                    case 2:
                        g1 = Hand.paper;
                           g2 = Random();

                        if (g2 == Hand.stone) {
                            bw.write("EL jugador 2 ha elegido piedra. ");
                            
                        } else if (g2 == Hand.paper) {
                            bw.write("EL jugador 2 ha elegido papel. ");
                            
                        } else {
                            bw.write("EL jugador 2 ha elegido tijeras. ");
                           
                        }

                        result = Game(g1, g2);
                        System.out.println(result);
                        bw.write(result);
                        bw.newLine();
                        bw.flush();
                        break;
                    case 3:
                        g1 = Hand.scissors;
                         g2 = Random();

                        if (g2 == Hand.stone) {
                            bw.write("EL jugador 2 ha elegido piedra. ");
                            
                        } else if (g2 == Hand.paper) {
                            bw.write("EL jugador 2 ha elegido papel. ");
                            
                        } else {
                            bw.write("EL jugador 2 ha elegido tijeras. ");
                           
                        }

                        result = Game(g1, g2);
                        System.out.println(result);
                        bw.write(result);
                        bw.newLine();
                        bw.flush();
                        break;
                }

            } while (true);

        } catch (IOException ex) {
            Logger.getLogger(ShocketJanken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String Game(Hand g1, Hand g2) {
        Jankenpon jkp = new Jankenpon();

        int win = jkp.win(g1, g2);
        String text;
        switch (win) {
            case 0:
                text = "Empate";
                System.out.println(text);
                return text;
            case 1:
                text = "Has ganado";
                System.out.println(text);
                return text;
            case -1:
                text = "Has perdido";
                System.out.println(text);
                return text;
        }
        return null;
    }

    private static Hand Random() {

        double numero = Math.floor((Math.random() * 3) + 1);
        Hand server;

        if (numero == 1) {
            server = Hand.stone;
        } else if (numero == 2) {
            server = Hand.paper;
        } else {
            server = Hand.scissors;

        }
        return server;
    }

}
