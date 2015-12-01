/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.*;
import java.util.Scanner;


/**
 *
 * @author Marlon Prudente <marlonmateuspr@gmail.com>
 */
public class ThreadTratamento implements Runnable  {
    Socket cliente;
    
    @Override 
    public void run () {            
            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
            
            /*Lê o que o cliente está enviando e mostra*/
            /*Scanner s = new Scanner(cliente.getInputStream());
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
            s.close();
            */
    }
   public ThreadTratamento(Socket cliente){
        this.cliente = cliente;
    }
}
