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

    public byte[] terminate(String inStr) {
        byte[] in = inStr.getBytes();
        byte[] out = new byte[in.length+1];
        for(int i = 0; i<in.length; i++) {
            out[i] = in[i];
        }
        out[in.length]=0;
        return out;
    }

    public void run () {

      input="";

      try {
          DataInputStream is =  new DataInputStream(server.getInputStream());
          DataOutputStream os =  new DataOutputStream(server.getOutputStream());

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

          //AUTHOK
         os.writeByte('R');
         os.writeInt(8);
         os.writeInt(0);


/*
          os.writeByte('K');
          os.writeInt(12);
          os.writeInt(2);
          os.writeInt(3);*/


         //PARAMETERSTATUS
          String param ="server_version";
          String paramV = "9";
          int lenP = param.getBytes().length+paramV.getBytes().length;
          System.out.println(lenP + " len");
          os.writeByte('S');
          byte[] nameB = terminate(param);  //PEACE OF SHIT NEEDS TO BE NULTERMINATED EVEN THOUGH DOCS DONT MENTION IT
          byte[] valB = terminate(paramV);
          os.writeInt(4+nameB.length+valB.length);
          os.write(nameB);
          os.write(valB);

         /* param ="server_version";
          paramV = "9";
          lenP = param.getBytes().length+paramV.getBytes().length;
          System.out.println(lenP+" len");
          os.writeByte('S');
          os.writeInt(lenP+4);
          os.writeChars(param);
          os.writeChars(paramV);*/

        //READYFORQUERY
         os.writeByte('Z');
         os.writeInt(5);
         os.writeByte('I');

          os.flush();

/*

          String m = "NEKA GRESKA";
          os.writeByte('E');
          os.writeInt(m.getBytes().length*2+4+1);
          os.writeByte('M');
          os.writeChars(m);
          os.flush();
*/



          while(true) {
              byte type = is.readByte();
              int msgLength = is.readInt();

              byte[] msgB = new byte[is.available()]; //check if this matches msgLength - 4
              is.read(msgB);

              //String msgString = parser.parseMsg(msgB); //if u want string representation


              //reply to the client msg, delete exit


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
