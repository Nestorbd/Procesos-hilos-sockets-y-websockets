/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jankenclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maqui
 */
public class JankenClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String HOST = "192.168.1.35";
        final int PORT = 45000;
        
        try {
            Socket socket = new Socket(HOST,PORT);
            
            talkToServer(socket);
        } catch (IOException ex) {
            Logger.getLogger(JankenClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
      private static void talkToServer(Socket socket){
        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            InputStream is = socket.getInputStream();
           InputStreamReader isr = new InputStreamReader(is);
           BufferedReader br = new BufferedReader(isr);
            
            Scanner sc = new Scanner(System.in);
            String lineTypedByUser;
            
            byte opcion= (-1);
            String lineFromClient;
            do{
            System.out.println("1: Piedra");
            System.out.println("2: Papel");
            System.out.println("3: Tijera");
                System.out.println("Introduzca cualquier otro número para cerrar");
            System.out.println("Introduzca una opción");
            lineTypedByUser = sc.nextLine();
            opcion=Byte.parseByte(lineTypedByUser);
            String text;
            switch(opcion){
                case 1:
                    text = "Has elegido Piedra";
                    System.out.println(text);
                    bw.write(opcion);
                    bw.newLine();
                    bw.flush();
                    break;
                case 2:
                    text = "Has elegido Papel";
                    System.out.println(text);
                    bw.write(opcion);
                    bw.newLine();
                    bw.flush();
                    break;
                case 3:
                    text = "Has elegido Tijeras";
                    System.out.println(text);
                    bw.write(opcion);
                    bw.newLine();
                    bw.flush();
                    break;
                 default:
                     System.exit(0);
                    break;
            }
            
            lineFromClient = br.readLine();
            System.out.println(lineFromClient);
            
            }while(true);
        } catch (IOException ex) {
            Logger.getLogger(JankenClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
