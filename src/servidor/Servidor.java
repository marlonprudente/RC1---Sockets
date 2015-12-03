/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import com.sun.net.httpserver.HttpServer;
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
        //HttpServer httpserver;
        ServerSocket SocketServidor = new ServerSocket(12345);
        //httpserver = new HttpServer("localhost",12345);
        System.out.println("Porta 12345 aberta!");

        while (true) {
            Socket connectionSocketCliente = SocketServidor.accept();
            System.out.println("Nova conexão com o cliente " + connectionSocketCliente.getInetAddress().getHostAddress());
            
            /*Aqui deve iniciar uma Thread para receber mais de uma conexão*/
            ThreadTratamento tt = new ThreadTratamento(connectionSocketCliente);
            Thread t = new Thread(tt);
            t.start();          

        }

    }
}