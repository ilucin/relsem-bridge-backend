package com.etk.network.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Helper class to receive well known kind of messages
 * 
 * @author Michele
 * 
 */
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
	 * Get the username used in the authentication message
	 * 
	 * @return the string representing the Username iff the authentication has
	 *         been already received. Null otherwise
	 */
	public String getUsername() {
		return this.username_;
	}

	/**
	 * Get the DataBase name used in the authentication message
	 * 
	 * @return the string representing the Username iff the authentication has
	 *         been already received. Null otherwise
	 */
	public String getDBName() {
		return this.dbName_;
	}

	/**
	 * Get the password used in the authentication message
	 * 
	 * @return the string representing the Password iff the authentication has
	 *         been already received and a password has been required. Null
	 *         otherwise
	 */
	public String getPassword() {
		try {
			this.dataInputStream_.readByte();
			int msgLength = dataInputStream_.readInt();
			// - 4 for message lenght
			byte[] buf = new byte[msgLength - 4];
			this.dataInputStream_.read(buf);
			byte delim = 0;
			ByteTokenizer bt = new ByteTokenizer(buf, delim);
			return this.parser_.parseMsg(bt.nexToken());
		} catch (IOException e) {
			System.out.println("Error in getPassword: ");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see java.io.FilterInputStream#available() flush
	 */
	public int available() throws IOException {
		return this.dataInputStream_.available();
	}

	/**
	 * Receive the authentication messages with DB name, username and other
	 * informations
	 * 
	 * @return false if the client required an SSL connection or if an exception
	 *         is thrown. True otherwise
	 */
	public boolean receiveAuthMessage() {
		try {
			int msgLen = dataInputStream_.readInt();
			if (msgLen == 8) {
				// THIS MEANS IT IS AN SSL REQUEST
				// the following line is only to empty the inputStream
				dataInputStream_.readInt();
				return false;
			} else {
				this.protocolMajorVersion_ = dataInputStream_.readShort();
				this.protocolMinorVersion_ = dataInputStream_.readShort();
				// System.out.println('v' + protocolMajorVersion_ + '.' +
				// protocolMinorVersion_);

				// -4 for message lenght, -2 for the protocolMajorVersion_, -2
				// for the protocolMinorVersion_
				byte[] buf = new byte[msgLen - 4 - 2 - 2];
				this.dataInputStream_.read(buf);

				// System.out.println("message: " + this.parser_.parseMsg(buf));

				byte delim = 0;
				ByteTokenizer bt = new ByteTokenizer(buf, delim);

				// "user" string
				bt.nexToken();
				this.username_ = this.parser_.parseMsg(bt.nexToken());
				// "database" string
				bt.nexToken();
				this.dbName_ = this.parser_.parseMsg(bt.nexToken());
				// from now on useless things like timezone, to print uncomment
				// the
				// following lines
				// while (bt.hasMoreTokens())
				// System.out.println(this.parser_.parseMsg(bt.nexToken()));
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error in receiveAuthMessage: ");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Understand which kind of message it is
	 * 
	 * @return the char that represent the type of the message
	 */
	public char getMessageType() {
		try {
			return (char) this.dataInputStream_.readByte();
		} catch (Exception e) {
		}
		return 'e';
	}

	/**
	 * Recognize a request to parse a query
	 * 
	 * @return The string representing the query iff the message is correct.
	 *         Null otherwise
	 */
	public String readParseMessage() {
		try {
			int msgLength = this.dataInputStream_.readInt();
			// - 4 for the message lenght
			byte[] buf = new byte[msgLength - 4];
			if (this.dataInputStream_.read(buf) > 0) {
				byte delim = '\0';
				ByteTokenizer bt = new ByteTokenizer(buf, delim);

				// from now on useless things like timezone, to print comment
				// out
				// following lines
				try {
					return this.parser_.parseMsg(bt.nexToken());
				} catch (Exception e) {
				}
			}
			return null;
		} catch (IOException e) {
			System.out.println("Error in readParseMessage: ");
			e.printStackTrace();
			return null;
		}
	}
}
