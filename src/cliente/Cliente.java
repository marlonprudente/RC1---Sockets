/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import java.io.*;
import java.net.*;
/**
 * @author Marlon Prudente
 * @author Mateus Oliveira
 */
public class Cliente {
    
    public static void main(String[] args) throws Exception {
        
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        /*Ip do Servidor e porta*/
        Socket clientSocket = new Socket("100.43.1.61",12345);
        
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
        BufferedReader InFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n' );
        modifiedSentence = InFromServer.readLine();
        
        System.out.println(modifiedSentence);
        clientSocket.close();
    }
    
}
