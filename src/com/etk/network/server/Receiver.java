package com.etk.network.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Receiver {

	private DataInputStream dataInputStream_;
	private MsgParser parser_;
	private short protocolMinorVersion_;
	private short protocolMajorVersion_;
	private String username_;
	private String dbName_;

	public Receiver(DataInputStream input) {
		this.dataInputStream_ = input;
		this.parser_ = new MsgParser();
		this.protocolMajorVersion_ = 0;
		this.protocolMinorVersion_ = 0;
		this.username_ = null;
		this.dbName_ = null;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return this.username_;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDBName() {
		return this.dbName_;
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		try {
			this.dataInputStream_.readByte();
			int msgLength = dataInputStream_.readInt();
			// - 4 for message lenght
			byte[] buf = new byte[msgLength - 4];
			this.dataInputStream_.read(buf);
			byte delim = 0;
			ByteTokenizer bt = new ByteTokenizer(buf , delim);
			return this.parser_.parseMsg(bt.nexToken());
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
	public void receiveAuthMessage() {
		try {
			int msgLen = dataInputStream_.readInt();
			this.protocolMajorVersion_ = dataInputStream_.readShort();
			this.protocolMinorVersion_ = dataInputStream_.readShort();

			// -4 for message lenght, -2 for the protocolMajorVersion_, -2 for
			// the protocolMinorVersion_
			byte[] buf = new byte[msgLen - 4 - 2 - 2];
			this.dataInputStream_.read(buf);
			byte delim = 0;
			ByteTokenizer bt = new ByteTokenizer(buf, delim);

			// "user" string
			bt.nexToken();
			this.username_ = this.parser_.parseMsg(bt.nexToken());
			// "database" string
			bt.nexToken();
			this.dbName_ = this.parser_.parseMsg(bt.nexToken());
			// from now on useless things like timezone, to print uncomment the
			// following lines
			// while (bt.hasMoreTokens())
			// System.out.println(this.parser_.parseMsg(bt.nexToken()));
		} catch (Exception e) {
			System.out.println("Error in receiveAuthMessage: ");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public char getMessageType() {
		try {
			return (char) this.dataInputStream_.readByte();
		} catch (Exception e) {
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
			// - 4 for the message lenght
			byte[] buf = new byte[msgLength - 4];
			this.dataInputStream_.read(buf);

			byte delim = '\0';
			ByteTokenizer bt = new ByteTokenizer(buf, delim);

			// from now on useless things like timezone, to print comment out
			// following lines
			// while (bt.hasMoreTokens())
			// System.out.println(this.parser_.parseMsg(bt.nexToken()));
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
