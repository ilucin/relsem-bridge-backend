package com.etk.network.server;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class MsgParser {

	public MsgParser() {
	}

	public short parseShort(byte[] bytes) throws IllegalArgumentException {
		if (bytes.length < 2)
			throw new IllegalArgumentException(
					"The array of bytes which represent the short int has less than 2 bytes");
		if (bytes.length > 2)
			throw new IllegalArgumentException(
					"The array of bytes which represent the short int has more than 2 bytes");
		return ByteBuffer.wrap(bytes).getShort();

	}

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

	public String parseMsg(byte[] bytes) throws UnsupportedEncodingException {
		String msgString = new String(bytes, "UTF-8");
		return msgString;
	}

}
