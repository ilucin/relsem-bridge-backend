package com.etk.network.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Receiver {

	DataInputStream dataInputStream_;
	MsgParser parser_;

	public Receiver(DataInputStream input) {
		this.dataInputStream_ = input;
		this.parser_ = new MsgParser();
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		try {
			this.dataInputStream_.readByte();
			int msgLength = dataInputStream_.readInt();
			// - 4 for message lenght, - 1 for terminator
			byte[] buf = new byte[msgLength - 4 - 1];
			this.dataInputStream_.read(buf);
			// remove the terminator
			this.dataInputStream_.readByte();
			return this.parser_.parseMsg(buf);
		} catch (IOException e) {
			System.out.println("Error in getPassword: ");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public int available() throws IOException {
		return this.dataInputStream_.available();
	}

	/**
	 * 
	 * @return
	 */
	public char getMessageType() {
		try {
			return (char) this.dataInputStream_.readByte();
		} catch (Exception e){
		}
		return 'e';
	}
	
	/**
	 * 
	 * @return
	 */
	public String readParseMessage() {
		try {
			int msgLength = this.dataInputStream_.readInt();
			// System.out.println("Lenght: " + msgLength);
			// remove the terminator of the first empty string
			this.dataInputStream_.readByte();
			// - 4 for the message lenght, - 1 for the terminator of the
			// first string, - 1 for the terminator of the first string, - 2 for
			// the number of parameter
			byte[] buf = new byte[msgLength - 4 - 1 - 1 - 2];
			this.dataInputStream_.read(buf);
			return this.parser_.parseMsg(buf);
		} catch (IOException e) {
			System.out.println("Error in readParseMessage: ");
			e.printStackTrace();
		}
		return null;
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
