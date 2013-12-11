package com.etk.network.server;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;

import com.etk.parser.ProjectionCell;
import com.etk.parser.SelectObject;
import com.etk.parser.SelectQueryToObject;

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

		byte[] nameB = nullTerminateString(param); // PEACE OF SHIT NEEDS TO BE
		// NULTERMINATED EVEN THOUGH DOCS
		// DONT MENTION IT
		byte[] valB = nullTerminateString(paramV);

		dataOutputStream.writeByte('S');
		dataOutputStream.writeInt(4 + nameB.length + valB.length);
		dataOutputStream.write(nameB);
		dataOutputStream.write(valB);
	}

	private void sendAuthenticationOkMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('R');
		dataOutputStream.writeInt(8);
		dataOutputStream.writeInt(0);
	}

	private void sendReadyForQueryMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('Z');
		dataOutputStream.writeInt(5);
		dataOutputStream.writeByte('I');
	}

	private void sendTerminateMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('X');
		dataOutputStream.writeInt(4);
	}

	private void sendCommandCompleteMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('C');
		String tmp = "SELECT 1";
		dataOutputStream.writeInt(4 + tmp.getBytes().length);
		dataOutputStream.write(tmp.getBytes());
	}

	private void sendParseCompleteMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('1');
		dataOutputStream.writeInt(4);
	}

	private void sendBindCompleteMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('2');
		dataOutputStream.writeInt(4);
	}

	private void sendEmptyQueryResponseMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('I');
		dataOutputStream.writeInt(4);
	}

	private void sendRowDescriptionMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('T');
		dataOutputStream.writeInt(27);
		dataOutputStream.writeShort(1);
		dataOutputStream.writeBytes("id");
		dataOutputStream.writeInt(32780);
		dataOutputStream.writeShort(3);
		dataOutputStream.writeInt(20);
		dataOutputStream.writeShort(8);
		dataOutputStream.writeInt(-1);
		dataOutputStream.writeShort(0);

	}

	/* Data row incorrect, needs to be finished */

	private void sendDataRowMessage(DataOutputStream dataOutputStream) {
		try {
			dataOutputStream.writeByte('D');
			// Problem with upper line, after that it brokes (tried with other
			// types of write after it). Why? Problem of size?
			// Tried wireshark, it sends ACK FIN
			dataOutputStream.writeInt(11);
			dataOutputStream.writeShort(1);
			dataOutputStream.writeInt(1);
			dataOutputStream.writeByte('1');
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	public void run() {

		input_ = "";

		try {
			DataInputStream dataInputStream = new DataInputStream(
					server_.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(
					server_.getOutputStream());

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

			sendAuthenticationOkMessage(dataOutputStream);

			/*
			 * os.writeByte('K'); os.writeInt(12); os.writeInt(2);
			 * os.writeInt(3);
			 */

			this.sendServerVersionMessage(dataOutputStream);

			this.sendReadyForQueryMessage(dataOutputStream);

			dataOutputStream.flush();

			/*
			 * I think now the client wants the result of the query
			 */

			// if (dataInputStream.available() > 0) {
			byte type = dataInputStream.readByte();
			int msgLength = dataInputStream.readInt();
			System.out.println("Message Type: " + (char) type);
			System.out.println("Lenght: " + msgLength);

			byte[] buf = new byte[dataInputStream.available() - 4];
			dataInputStream.read(buf);
			String inputString = msgParser.parseMsg(buf);
			System.out.println(inputString);
			InputStream is = new
			    ByteArrayInputStream(inputString.getBytes("UTF-8"));

            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //Actual parsing of query and creation of selectObject which contains the query data:
            SelectQueryToObject selectQueryToObject = new SelectQueryToObject(is);
            SelectObject selectObject = selectQueryToObject.getSelectObject();


            //just for understanding of how to use selectObject:
      /*      for(String noPrefColName : selectObject.getNoPrefColNames()){
                System.out.println("Column: " + noPrefColName);
            }
        */
            for(ProjectionCell prefColName : selectObject.getPrefColNames()){
                System.out.println("Prefixed column found \n    prefix: " + prefColName.getPrefix()
                                    + "\n     column name: " + prefColName.getColumnName());
            }

            for(String tableName : selectObject.getTableNames()){
                System.out.println("Table: " + tableName);
            }

			/*
			 * this is in case the server receive an empty query string and
			 * seems to work sendEmptyQueryResponseMessage(dataOutputStream);
			 * sendReadyForQueryMessage(dataOutputStream);
			 * dataOutputStream.flush();
			 */

			sendData(dataOutputStream);
			dataOutputStream.flush();

			sendCommandCompleteMessage(dataOutputStream);
			sendReadyForQueryMessage(dataOutputStream);
			dataOutputStream.flush();

			// reply to the client msg, delete exit
			// }

		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendData(DataOutputStream dataOutputStream) throws IOException {
		/*
		 * RowDescription (B) Byte1('T') Identifies the message as a row
		 * description. Int32 Length of message contents in bytes, including
		 * self. Int16 Specifies the number of fields in a row (may be zero).
		 * Then, for each field, there is the following: String The field name.
		 * Int32 If the field can be identified as a column of a specific table,
		 * the object ID of the table; otherwise zero. Int16 If the field can be
		 * identified as a column of a specific table, the attribute number of
		 * the column; otherwise zero. Int32 The object ID of the field's data
		 * type. Int16 The data type size (see pg_type.typlen). Note that
		 * negative values denote variable-width types. Int32 The type modifier
		 * (see pg_attribute.atttypmod). The meaning of the modifier is
		 * type-specific. Int16 The format code being used for the field.
		 * Currently will be zero (text) or one (binary). In a RowDescription
		 * returned from the statement variant of Describe, the format code is
		 * not yet known and will always be zero.
		 * 
		 * SSLRequest (F)
		 */

		short fieldsNo = 4;

		String name = "name";
		byte[] bName = nullTerminateString(name);
		int identificator = 0;
		short identificatorAtr = 0;
		int typeInd = 0;
		short typeLen = -2;
		int typeMod = -1;
		short formatCode = 0;

		String name2 = "surname";
		byte[] bName2 = nullTerminateString(name2);
		int identificator2 = 0;
		short identificatorAtr2 = 0;
		int typeInd2 = 0;
		short typeLen2 = -2;
		int typeMod2 = -1;
		short formatCode2 = 0;

		String name3 = "date";
		byte[] bName3 = nullTerminateString(name3);
		int identificator3 = 0;
		short identificatorAtr3 = 0;
		int typeInd3 = 0;
		short typeLen3 = -2;
		int typeMod3 = -1;
		short formatCode3 = 0;

		String name4 = "number";
		byte[] bName4 = nullTerminateString(name4);
		int identificator4 = 0;
		short identificatorAtr4 = 0;
		int typeInd4 = 0;
		short typeLen4 = -2;
		int typeMod4 = -1;
		short formatCode4 = 0;

		int totalSize = bName.length + 4 + 2 + 4 + 2 + 4 + 2 + 4
				+ bName3.length + 4 + 2 + 4 + 2 + 2 + bName4.length + 4 + 2 + 4
				+ 2 + 2;

		dataOutputStream.writeByte('T');
		dataOutputStream.writeInt(totalSize);
		dataOutputStream.writeShort(fieldsNo);

		dataOutputStream.writeBytes(new String(bName));
		dataOutputStream.writeInt(identificator);
		dataOutputStream.writeShort(identificatorAtr);
		dataOutputStream.writeInt(typeInd);
		dataOutputStream.writeShort(typeLen);
		dataOutputStream.writeInt(typeMod);
		dataOutputStream.writeShort(formatCode);

		dataOutputStream.writeBytes(new String(bName2));
		dataOutputStream.writeInt(identificator2);
		dataOutputStream.writeShort(identificatorAtr2);
		dataOutputStream.writeInt(typeInd2);
		dataOutputStream.writeShort(typeLen2);
		dataOutputStream.writeInt(typeMod2);
		dataOutputStream.writeShort(formatCode2);

		dataOutputStream.writeBytes(new String(bName3));
		dataOutputStream.writeInt(identificator3);
		dataOutputStream.writeShort(identificatorAtr3);
		dataOutputStream.writeInt(typeInd3);
		dataOutputStream.writeShort(typeLen3);
		dataOutputStream.writeInt(typeMod3);
		dataOutputStream.writeShort(formatCode3);

		dataOutputStream.writeBytes(new String(bName4));
		dataOutputStream.writeInt(identificator4);
		dataOutputStream.writeShort(identificatorAtr4);
		dataOutputStream.writeInt(typeInd4);
		dataOutputStream.writeShort(typeLen4);
		dataOutputStream.writeInt(typeMod4);
		dataOutputStream.writeShort(formatCode4);

		/*
		 * Byte1('D') Identifies the message as a data row.
		 * 
		 * Int32 Length of message contents in bytes, including self.
		 * 
		 * Int16 The number of column values that follow (possibly zero).
		 * 
		 * Next, the following pair of fields appear for each column:
		 * 
		 * Int32 The length of the column value, in bytes (this count does not
		 * include itself). Can be zero. As a special case, -1 indicates a NULL
		 * column value. No value bytes follow in the NULL case.
		 * 
		 * Byten The value of the column, in the format indicated by the
		 * associated format code. n is the above lengt
		 */
		
		for ( int i = 0; i < 2; i++){

		int tLen = 0;
		short num = 4;

		String val = "david";
		int lenCol = nullTerminateString(val).length;
		byte[] bval = nullTerminateString(val);

		String val2 = "riobo";
		int lenCol2 = nullTerminateString(val2).length;
		byte[] bval2 = nullTerminateString(val2);

		String val3 = "1992-01-17";
		int lenCol3 = nullTerminateString(val3).length;
		byte[] bval3 = nullTerminateString(val3);

		String val4 = "-87,61";
		int lenCol4 = nullTerminateString(val4).length;
		byte[] bval4 = nullTerminateString(val4);

		tLen = 4 + 2 + 4 + bval.length + 4 + bval2.length + 4 + bval3.length
				+ 4 + bval4.length;
		dataOutputStream.writeByte('D');
		dataOutputStream.writeInt(tLen);
		dataOutputStream.writeShort(num);

		dataOutputStream.writeInt(lenCol);
		dataOutputStream.writeBytes(new String(nullTerminateString(val)));

		dataOutputStream.writeInt(lenCol2);
		dataOutputStream.writeBytes(new String(nullTerminateString(val2)));

		// Returns Bad value for type date : 1992-01-17

		dataOutputStream.writeInt(lenCol3);
		dataOutputStream.writeBytes(new String(nullTerminateString(val3)));

		// Returns Bad value for type date too
		
		dataOutputStream.writeInt(lenCol4);
		dataOutputStream.writeBytes(new String(nullTerminateString(val4)));
		
		}
		
		dataOutputStream.flush();

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
