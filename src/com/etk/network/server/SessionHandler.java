package com.etk.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

class SessionHandler implements Runnable {
	private Socket server_;
	private String line_, input_;

	SessionHandler(Socket server) {
		this.server_ = server;
	}

	private byte[] nullTerminateString(String string) {
		byte[] in = string.getBytes();
		byte[] out = new byte[in.length + 1];
		for (int i = 0; i < in.length; i++) {
			out[i] = in[i];
		}
		out[in.length] = 0;
		return out;
	}

	private void sendServerVersionMessage(DataOutputStream dataOutputStream)
			throws IOException {
		String param = "server_version";
		String paramV = "9";
		int lenP = param.getBytes().length + paramV.getBytes().length;
		
		dataOutputStream.writeByte('S');
		byte[] nameB = nullTerminateString(param); // PEACE OF SHIT NEEDS TO BE
		// NULTERMINATED EVEN THOUGH DOCS
		// DONT MENTION IT
		byte[] valB = nullTerminateString(paramV);
		dataOutputStream.writeInt(4 + nameB.length + valB.length);
		dataOutputStream.write(nameB);
		dataOutputStream.write(valB);
	}

	private void sendAuthenticationOkMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte(new Character('R'));
		dataOutputStream.writeInt(8);
		dataOutputStream.writeInt(0);
	}

	private void sendReadyForQueryMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('Z');
		dataOutputStream.writeInt(5);
		dataOutputStream.writeByte('I');
	}

	public void run() {

		input_ = "";

		try {
			DataInputStream dataInputStream = new DataInputStream(server_.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(
					server_.getOutputStream());

			MsgParser msgParser = new MsgParser();

			int msgLen = dataInputStream.readInt();
			short protocolMajorVersion = dataInputStream.readShort();
			short protocolMinorVersion = dataInputStream.readShort();

			byte[] authParamsB = new byte[msgLen - 8]; // msglen - version and
														// len
			dataInputStream.read(authParamsB);
			String authParams = msgParser.parseMsg(authParamsB);

			System.out.println("Client connected!");
			System.out.println("Msg len: " + msgLen);
			System.out.println("Protocol: V" + protocolMajorVersion + "."
					+ protocolMinorVersion);

			System.out.println("Auth params: " + authParams);

			sendAuthenticationOkMessage(dataOutputStream);

			/*
			 * os.writeByte('K'); os.writeInt(12); os.writeInt(2);
			 * os.writeInt(3);
			 */

			this.sendServerVersionMessage(dataOutputStream);

			this.sendReadyForQueryMessage(dataOutputStream);

			dataOutputStream.flush();

			/*
			 * 
			 * String m = "NEKA GRESKA"; os.writeByte('E');
			 * os.writeInt(m.getBytes().length*2+4+1); os.writeByte('M');
			 * os.writeChars(m); os.flush();
			 */

			while (true) {
				byte type = dataInputStream.readByte();
				int msgLength = dataInputStream.readInt();

				byte[] msgB = new byte[dataInputStream.available()]; // check if this matches
														// msgLength - 4
				dataInputStream.read(msgB);

				// String msgString = parser.parseMsg(msgB); //if u want string
				// representation

				// reply to the client msg, delete exit

			}

		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		}
	}

	private class MsgParser {

		public short parseShort(byte[] bytes) {
			byte[] typeBytes = new byte[2];
			typeBytes[0] = 0;
			typeBytes[1] = bytes[0];
			return ByteBuffer.wrap(typeBytes).getShort();

		}

		public int parseInt(byte[] bytes) {
			byte[] lenBytes = Arrays.copyOf(bytes, 4);
			int len = ByteBuffer.wrap(lenBytes).getInt();
			return len;
		}

		public String parseMsg(byte[] bytes) {
			String msgString = new String(bytes, Charset.forName("UTF-8"));
			return msgString;
		}

	}

}
