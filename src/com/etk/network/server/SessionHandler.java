package com.etk.network.server;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;

import com.etk.parser.SelectObject;
import com.etk.parser.SelectQueryToObject;

class SessionHandler implements Runnable {
	private Socket server_;
	private Sender sender_;

	public SessionHandler(Socket server) {
		this.server_ = server;
		try {
			this.sender_ = new Sender(new DataOutputStream(
					server_.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Data row incorrect, needs to be finished */

	public void run() {

		try {
			DataInputStream dataInputStream = new DataInputStream(
					server_.getInputStream());

			MsgParser msgParser = new MsgParser();

			int msgLen = dataInputStream.readInt();
			short protocolMajorVersion = dataInputStream.readShort();
			short protocolMinorVersion = dataInputStream.readShort();

			byte[] authParamsB = new byte[msgLen - 8]; // msglen - version and
														// len
			dataInputStream.read(authParamsB);
			// String authParams = msgParser.parseMsg(authParamsB);

			System.out.println("Client connected!");
			// System.out.println("Msg len: " + msgLen);
			System.out.println("Protocol: V" + protocolMajorVersion + "."
					+ protocolMinorVersion);

			// System.out.println("Auth params: " + authParams);

			this.sender_.sendAuthenticationOkMessage();
			this.sender_.sendServerVersionMessage();
			this.sender_.sendReadyForQueryMessage();
			this.sender_.flush();

			// if (dataInputStream.available() > 0) {
			byte type = dataInputStream.readByte();
			int msgLength = dataInputStream.readInt();
			System.out.println("Message Type: " + (char) type);
			System.out.println("Lenght: " + msgLength);

			byte[] buf = new byte[dataInputStream.available() - 4];
			dataInputStream.read(buf);
			String inputString = msgParser.parseMsg(buf);
			System.out.println(inputString);
			InputStream is = new ByteArrayInputStream(
					inputString.getBytes("UTF-8"));
			SelectQueryToObject transform = new SelectQueryToObject(is);
			SelectObject selectObject = transform.getSelectObject();

			System.out.println("Parser found tables: "
					+ selectObject.getTableNames().toString()
					+ "\nParser found columns: "
					+ selectObject.getColumnNames().toString());
			// InputStream is = new
			// ByteArrayInputStream(inputString.getBytes("UTF-8"));
			// SELECTMain.parse(is);
			

			/*
			 * this is in case the server receive an empty query string and
			 * seems to work sendEmptyQueryResponseMessage(dataOutputStream);
			 * sendReadyForQueryMessage(dataOutputStream);
			 * dataOutputStream.flush();
			 */

			String[] columns = { "name", "surname" };
			this.sender_.sendRowDescription(columns);
			String[] values = { "david", "riobo" };
			this.sender_.sendDataRow(values);
			this.sender_.flush();

			this.sender_.sendCommandCompleteMessage();
			this.sender_.sendReadyForQueryMessage();
			this.sender_.flush();

			// reply to the client msg, delete exit
			// }

		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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

		public String parseMsg(byte[] bytes)
				throws UnsupportedEncodingException {
			String msgString = new String(bytes, "UTF-8");
			return msgString;
		}

	}

}
