package com.etk.network.server;
import java.io.*;
import java.net.*;
import java.security.*;


public class sample_server {

  private static int port=5000, maxConnections=0;
  // Listen for incoming connections and handle them
  public static void main(String[] args) {
    int i=0;

    try{
      ServerSocket listener = new ServerSocket(port);
      Socket server;

      while((i++ < maxConnections) || (maxConnections == 0)){
        doComms connection;

        server = listener.accept();
        doComms conn_c= new doComms(server);
        Thread t = new Thread(conn_c);
        t.start();
      }
    } catch (IOException ioe) {
      System.out.println("IOException on socket listen: " + ioe);
      ioe.printStackTrace();
    }
  }

}
