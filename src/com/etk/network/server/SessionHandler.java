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
		String tmp = "SELECT 0";
		dataOutputStream.writeInt(4 + tmp.getBytes().length);
		dataOutputStream.write(tmp.getBytes());
	}

	private void sendParseCompleteMessage(DataOutputStream dataOutputStream)
			throws IOException {
		dataOutputStream.writeByte('1');
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
		dataOutputStream.writeInt(6);
		dataOutputStream.writeShort(0);
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
			 * I think now the client wants the result of the query
			 */
			while (true) {

				if (dataInputStream.available() > 0) {
					byte type = dataInputStream.readByte();
					int msgLength = dataInputStream.readInt();
					System.out.println("Message Type: " + (char) type);
					System.out.println("Lenght: " + msgLength);

					byte[] buf = new byte[dataInputStream.available() - 4];
					dataInputStream.read(buf);
					String inputString = msgParser.parseMsg(buf);
					System.out.println(inputString);

					/*
					 * this is in case the server receive an empty query string
					 * and seems to work
					 * sendEmptyQueryResponseMessage(dataOutputStream);
					 * sendReadyForQueryMessage(dataOutputStream);
					 * dataOutputStream.flush();
					 */

                    sendData(dataOutputStream);
                    dataOutputStream.flush();
					sendCommandCompleteMessage(dataOutputStream);
					dataOutputStream.flush();





					sendReadyForQueryMessage(dataOutputStream);
                    dataOutputStream.flush();

					// reply to the client msg, delete exit
				}

			}

		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		}
	}

    private void sendData(DataOutputStream dataOutputStream) throws IOException {
        /*RowDescription (B)
        Byte1('T')
                Identifies the message as a row description.
                Int32   Length of message contents in bytes, including self.
                Int16   Specifies the number of fields in a row (may be zero).
                Then, for each field, there is the following:
        String
        The field name.
        Int32
        If the field can be identified as a column of a specific table, the object ID of the table; otherwise zero.
        Int16
        If the field can be identified as a column of a specific table, the attribute number of the column; otherwise zero.
        Int32
        The object ID of the field's data type.
        Int16
        The data type size (see pg_type.typlen). Note that negative values denote variable-width types.
        Int32
        The type modifier (see pg_attribute.atttypmod). The meaning of the modifier is type-specific.
        Int16
        The format code being used for the field. Currently will be zero (text) or one (binary). In a RowDescription returned from the statement variant of Describe, the format code is not yet known and will always be zero.

                SSLRequest (F)*/
        dataOutputStream.writeByte('T');

        short fieldsNo = 1;

        String name = "id";
        byte[] bName = nullTerminateString(name);
        int identificator = 0;
        short identificatorAtr = 0;
        int typeInd = 0;
        short typeLen = -2;
        int typeMod = -1;
        short formatCode = 0;

        int totalSize = bName.length + 4 +2 +4 +2 + 4 +2+4;

        dataOutputStream.writeInt(totalSize);
        dataOutputStream.writeShort(fieldsNo);
        dataOutputStream.writeBytes(new String(bName));
        dataOutputStream.writeInt(identificator);
        dataOutputStream.writeShort(identificatorAtr);
        dataOutputStream.writeInt(typeInd);
        dataOutputStream.writeShort(typeLen);
        dataOutputStream.writeInt(typeMod);
        dataOutputStream.writeShort(formatCode);



/*
        Byte1('D')
        Identifies the message as a data row.

                Int32
        Length of message contents in bytes, including self.

                Int16
        The number of column values that follow (possibly zero).

                Next, the following pair of fields appear for each column:

        Int32
        The length of the column value, in bytes (this count does not include itself). Can be zero. As a special case, -1 indicates a NULL column value. No value bytes follow in the NULL case.

        Byten
        The value of the column, in the format indicated by the associated format code. n is the above lengt*/

        int tLen = 0;
        short num = 1;
        String val = "324";
        int lenCol = nullTerminateString(val).length;
        byte[] bval = nullTerminateString(val);

        tLen = 4+2+4+bval.length;
        dataOutputStream.writeByte('D');
        dataOutputStream.writeInt(tLen);
        dataOutputStream.writeShort(num);
        dataOutputStream.writeInt(lenCol);
        dataOutputStream.writeBytes(new String(nullTerminateString(val)));

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

		public String parseMsg(byte[] bytes) {
			String msgString = new String(bytes, Charset.forName("UTF-8"));
			return msgString;
		}

	}

}
