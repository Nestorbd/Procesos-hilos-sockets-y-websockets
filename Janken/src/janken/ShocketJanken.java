/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janken;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maqui
 */
public class ShocketJanken {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int PORT = 45000;
        
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            
            while (true){
                Socket socket = serverSocket.accept();
                new AttendToClient(socket).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ShocketJanken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
