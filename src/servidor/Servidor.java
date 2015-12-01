/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Marlon Prudente
 * @author Mateus Oliveira
 */
public class Servidor {

    public static void main(String[] args) throws Exception {
        String clientSentence;
        String capitalizedSentence;

        ServerSocket SocketServidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");

        while (true) {
            Socket connectionSocketCliente = SocketServidor.accept();
            System.out.println("Nova conexão com o cliente " + connectionSocketCliente.getInetAddress().getHostAddress());

            Scanner s = new Scanner(connectionSocketCliente.getInputStream());
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
            s.close();
            
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocketCliente.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocketCliente.getOutputStream());

            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase();
            outToClient.writeBytes(capitalizedSentence);

        }

    }
}
