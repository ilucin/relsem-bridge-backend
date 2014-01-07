package com.etk.network.server;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * An helper class to manage the bytes cast into other formats (int, short int,
 * string)
 * 
 * @author Michele
 * 
 */
public class MsgParser {

	private String charsetName_;

	/**
	 * The "UTF-8" charset will be used.
	 */
	public MsgParser() {
		this.charsetName_ = "UTF-8";
	}

	/**
	 * Specify the charset to parse messages. The "UTF-8" will be used if the
	 * input is null or an empty string
	 * 
	 * @param charsetName
	 *            thecharset to use
	 */
	public MsgParser(String charsetName) {
		// TODO check charsetName validity
		if (charsetName != null && !charsetName.isEmpty())
			this.charsetName_ = charsetName;
		else
			this.charsetName_ = "UTF-8";
	}

	/**
	 * Take a 2 bytes lenght array and returns the corrisponding short int
	 * 
	 * @param bytes
	 *            The bytes that represent the short int
	 * @return The short int number
	 * @throws IllegalArgumentException
	 *             iff the input has less than 2 bytes or more than 2 bytes
	 */
	public short parseShort(byte[] bytes) throws IllegalArgumentException {
		if (bytes.length < 2)
			throw new IllegalArgumentException(
					"The array of bytes which represent the short int has less than 2 bytes");
		if (bytes.length > 2)
			throw new IllegalArgumentException(
					"The array of bytes which represent the short int has more than 2 bytes");
		return ByteBuffer.wrap(bytes).getShort();

	}

	/**
	 * Take a 4 bytes lenght array and returns the corrisponding int
	 * 
	 * @param bytes
	 *            The bytes that represent the int
	 * @return The int number
	 * @throws IllegalArgumentException
	 *             iff the input has less than 4 bytes or more than 4 bytes
	 */
	public int parseInt(byte[] bytes) throws IllegalArgumentException {
		if (bytes.length < 4)
			throw new IllegalArgumentException(
					"The array of bytes which represent the integer has less than 4 bytes");
		if (bytes.length > 4)
			throw new IllegalArgumentException(
					"The array of bytes which represent the integer has more than 4 bytes");
		int len = ByteBuffer.wrap(bytes).getInt();
		return len;
	}
	
	/**
	 * Take an array of bytes and returns the corrisponding string
	 * 
	 * @param bytes
	 *            The bytes that represent the string
	 * @return The string
	 * @throws UnsupportedEncodingException
	 *             iff the named charset is not supported
	 */
	public String parseMsg(byte[] bytes) throws UnsupportedEncodingException {
		String msgString = new String(bytes, this.charsetName_);
		return msgString;
	}

}
