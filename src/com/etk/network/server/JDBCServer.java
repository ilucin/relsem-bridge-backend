package com.etk.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JDBCServer {

  private static int port=5000;
  //TODO implement max number of connections?
  
  // Listen for incoming connections and handle them
  public static void main(String[] args) {
    try{
      ServerSocket listener = new ServerSocket(port);
      Socket server;
        System.out.println("server started!");
      while(true){
        server = listener.accept();
        System.out.println("connection accepted");
        SessionHandler conn_c= new SessionHandler(server);
        Thread t = new Thread(conn_c);
        t.start();
      }
      
    } catch (IOException ioe) {
      System.out.println("IOException on socket listen: " + ioe);
      ioe.printStackTrace();
    }
  }

}
