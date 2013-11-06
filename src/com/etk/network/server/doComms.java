package com.etk.network.server;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

class doComms implements Runnable {
    private Socket server;
    private String line,input;

    doComms(Socket server) {
      this.server=server;
    }

    public void run () {

      input="";

      try {
        // Get input from the client
        DataInputStream in = new DataInputStream (server.getInputStream());
        PrintStream out = new PrintStream(server.getOutputStream());

        while((line = in.readLine()) != null && !line.equals(".")) {
          input=input + line;
          out.println("I got:" + line);
        }

        // Now write to the client

        System.out.println("Overall message is:" + input);
        out.println("Overall message is:" + input);

        server.close();
      } catch (IOException ioe) {
        System.out.println("IOException on socket listen: " + ioe);
        ioe.printStackTrace();
      }
    }
}