package com.etk.network.server;
import java.io.*;
import java.net.*;


public class JDBCServer {

  private static int port=5000, maxConnections=0;
  // Listen for incoming connections and handle them
  public static void main(String[] args) {
    int i=0;

    try{
      ServerSocket listener = new ServerSocket(port);
      Socket server;
        System.out.println("server started!");
      while(true){
        SessionHandler connection;

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
