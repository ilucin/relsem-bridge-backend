package com.etk.network.server;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class MsgParser {

	public MsgParser(){
		
	}
	
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
