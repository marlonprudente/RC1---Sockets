/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.net.httpserver.HttpServer;
import java.io.File;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Marlon Prudente <marlonmateuspr@gmail.com>
 */
public class ThreadTratamento implements Runnable {
    Socket cliente;
    ServerSocket SocketServidor;
    protected Thread runningThread = null;
    String clientSentence;
    String capitalizedSentence;
    byte[] conteudo;
    @Override 
    public void run  () {      
            try{
                
                            

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(cliente.getOutputStream());
            
            File arquivo = new File("index.html");
            if(!arquivo.exists()){
                arquivo = new File("404.html");
            }
            conteudo = Files.readAllBytes(arquivo.toPath());
            outToClient.write(conteudo);
            outToClient.flush();
            
            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase();
            outToClient.writeBytes(capitalizedSentence);
            
            
            /*Lê o que o cliente está enviando e mostra*/ 
           Scanner s = new Scanner(cliente.getInputStream());
            while (s.hasNextLine()) {
                System.out.print("Cliente: " + cliente.getInetAddress().getHostAddress() + " ");
                System.out.println(s.nextLine());
            }
            s.close(); 
            
            }catch(Exception ex){
                System.out.println(ex);
            }
    }
   public ThreadTratamento() throws IOException{        
        this.SocketServidor = new ServerSocket(12345);
    }
      public ThreadTratamento(Socket cliente) throws IOException{        
        this.cliente = cliente;
    }
      
      public void OpenServerSocket() throws IOException{
          this.SocketServidor = new ServerSocket(12345);
      }      
 
}
