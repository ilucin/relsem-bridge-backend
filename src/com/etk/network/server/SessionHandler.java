package com.etk.network.server;
import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

class SessionHandler implements Runnable {
    private Socket server;
    private String line,input;

    SessionHandler(Socket server) {
      this.server=server;
    }

    public void run () {

      input="";

      try {
          DataInputStream is =  new DataInputStream(server.getInputStream());
          OutputStream os = server.getOutputStream();

          MsgParser parser = new MsgParser();

          int msgLen = is.readInt();
          short protocolMajorVersion = is.readShort();
          short protocolMinorVersion = is.readShort();

          byte[] authParamsB = new byte[msgLen-8]; //msglen - version and len
          is.read(authParamsB);
          String authParams = parser.parseMsg(authParamsB);

          System.out.println("Client connected!");
          System.out.println("Msg len: "+msgLen);
          System.out.println("Protocol: V"+protocolMajorVersion+"."+protocolMinorVersion);

          System.out.println("Auth params: "+authParams);


          //REPLY AUTHOK  //1 byte 2 ints  NOT WORKING, TRY SOMETHING ELSE
          /*byte[] authOkReply = new byte[1+4*2];
          authOkReply[0] = 'R';
          authOkReply[1] = 8;

          os.write(authOkReply);
          os.flush();*/


          while(true) {
              byte type = is.readByte();
              int msgLength = is.readInt();

              byte[] msgB = new byte[is.available()]; //check if this matches msgLength - 4
              is.read(msgB);

              //String msgString = parser.parseMsg(msgB); //if u want string representation


              //reply to the client msg, delete exit
              System.exit(0);

          }




      } catch (IOException ioe) {
        System.out.println("IOException on socket listen: " + ioe);
        ioe.printStackTrace();
      }
    }

    private class MsgParser {

        public short parseShort(byte[] msg) {
            byte[] typeBytes = new byte[2];
            typeBytes[0] = 0;
            typeBytes[1] = msg[0];
            return ByteBuffer.wrap(typeBytes).getShort();

        }

        public int parseInt(byte[] msg){
            byte[] lenBytes = Arrays.copyOf(msg,4);
            int len = ByteBuffer.wrap(lenBytes).getInt();
            return len;
        }

        public String parseMsg(byte[] msg){
            String msgString = new String(msg,Charset.forName("UTF-8"));
            return msgString;
        }


    }

}
