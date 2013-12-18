package com.etk.network.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.etk.db.query.QueryResult;
import com.etk.manager.schema.Type;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Sender {

	public static enum AuthEnum {
		AuthOK, KerberosV5Required, ClearTextPasswordRequired, MD5EncryptedPasswordRequired
	}
	private DataOutputStream dataOutputStream_;

	public Sender(DataOutputStream output) {
		this.dataOutputStream_ = output;
	}
	
	/**
	 * 
	 */
	public void sendWeDontManageSSL() {
		try {
			this.dataOutputStream_.writeByte('N');
		} catch (IOException e) {
			System.out.println("Error in sendParseCompleteMessage: ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void sendParseCompleteMessage() {
		try {
			this.dataOutputStream_.writeByte('1');
			this.dataOutputStream_.writeInt(4);
		} catch (IOException e) {
			System.out.println("Error in sendParseCompleteMessage: ");
			e.printStackTrace();
		}

	}
	
	/**
	 * send an error message to the client
	 * 
	 * @param error
	 *            the error to report to the client
	 */
	public void sendErrorResponse(String error) {
		try {
			this.dataOutputStream_.writeByte('E');
			byte[] temp = this.nullTerminateString(error);
			this.dataOutputStream_.writeInt(temp.length + 4 + 1);
			// you can find all types of messages here:
			// http://www.postgresql.org/docs/9.3/static/protocol-error-fields.html
			this.dataOutputStream_.writeByte('S');
			this.dataOutputStream_.write(temp);
			// an error message is always followed by a "ready for query"
			// message. I put the call to this method here so we can manage the
			// sendErrorResponse method "transparently"
			this.sendReadyForQueryMessage();
		} catch (IOException e) {
			System.out.println("Error in sendErrorResponse: ");
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 */
	private void sendData() {
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

		try {
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
					+ bName3.length + 4 + 2 + 4 + 2 + 2 + bName4.length + 4 + 2
					+ 4 + 2 + 2;

			this.dataOutputStream_.writeByte('T');
			this.dataOutputStream_.writeInt(totalSize);
			this.dataOutputStream_.writeShort(fieldsNo);

			this.dataOutputStream_.writeBytes(new String(bName));
			this.dataOutputStream_.writeInt(identificator);
			this.dataOutputStream_.writeShort(identificatorAtr);
			this.dataOutputStream_.writeInt(typeInd);
			this.dataOutputStream_.writeShort(typeLen);
			this.dataOutputStream_.writeInt(typeMod);
			this.dataOutputStream_.writeShort(formatCode);

			this.dataOutputStream_.writeBytes(new String(bName2));
			this.dataOutputStream_.writeInt(identificator2);
			this.dataOutputStream_.writeShort(identificatorAtr2);
			this.dataOutputStream_.writeInt(typeInd2);
			this.dataOutputStream_.writeShort(typeLen2);
			this.dataOutputStream_.writeInt(typeMod2);
			this.dataOutputStream_.writeShort(formatCode2);

			this.dataOutputStream_.writeBytes(new String(bName3));
			this.dataOutputStream_.writeInt(identificator3);
			this.dataOutputStream_.writeShort(identificatorAtr3);
			this.dataOutputStream_.writeInt(typeInd3);
			this.dataOutputStream_.writeShort(typeLen3);
			this.dataOutputStream_.writeInt(typeMod3);
			this.dataOutputStream_.writeShort(formatCode3);

			this.dataOutputStream_.writeBytes(new String(bName4));
			this.dataOutputStream_.writeInt(identificator4);
			this.dataOutputStream_.writeShort(identificatorAtr4);
			this.dataOutputStream_.writeInt(typeInd4);
			this.dataOutputStream_.writeShort(typeLen4);
			this.dataOutputStream_.writeInt(typeMod4);
			this.dataOutputStream_.writeShort(formatCode4);

			/*
			 * Byte1('D') Identifies the message as a data row.
			 * 
			 * Int32 Length of message contents in bytes, including self.
			 * 
			 * Int16 The number of column values that follow (possibly zero).
			 * 
			 * Next, the following pair of fields appear for each column:
			 * 
			 * Int32 The length of the column value, in bytes (this count does
			 * not include itself). Can be zero. As a special case, -1 indicates
			 * a NULL column value. No value bytes follow in the NULL case.
			 * 
			 * Byten The value of the column, in the format indicated by the
			 * associated format code. n is the above lengt
			 */

			for (int i = 0; i < 2; i++) {

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

				tLen = 4 + 2 + 4 + bval.length + 4 + bval2.length + 4
						+ bval3.length + 4 + bval4.length;
				this.dataOutputStream_.writeByte('D');
				this.dataOutputStream_.writeInt(tLen);
				this.dataOutputStream_.writeShort(num);

				this.dataOutputStream_.writeInt(lenCol);
				this.dataOutputStream_.writeBytes(new String(
						nullTerminateString(val)));

				this.dataOutputStream_.writeInt(lenCol2);
				this.dataOutputStream_.writeBytes(new String(
						nullTerminateString(val2)));

				// Returns Bad value for type date : 1992-01-17

				this.dataOutputStream_.writeInt(lenCol3);
				this.dataOutputStream_.writeBytes(new String(
						nullTerminateString(val3)));

				// Returns Bad value for type date too

				this.dataOutputStream_.writeInt(lenCol4);

				this.dataOutputStream_.writeBytes(new String(
						nullTerminateString(val4)));
			}
		} catch (IOException e) {
			System.out.println("Error in sendData: ");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param string
	 *            the string that needs to be null terminated
	 * @return a array of bytes representing the string and the terminator
	 */
	private byte[] nullTerminateString(String string) {
		byte[] in = string.getBytes();
		byte[] out = new byte[in.length + 1];
		for (int i = 0; i < in.length; i++) {
			out[i] = in[i];
		}
		out[in.length] = '\0';
		return out;
	}

	/**
	 * Send the server version to the client
	 */
	public void sendServerVersionMessage() {
		try {
			String param = "server_version";
			String paramV = "9";

			byte[] nameB = nullTerminateString(param);
			byte[] valB = nullTerminateString(paramV);

			this.dataOutputStream_.writeByte('S');
			this.dataOutputStream_.writeInt(4 + nameB.length + valB.length);
			this.dataOutputStream_.write(nameB);

			this.dataOutputStream_.write(valB);
		} catch (IOException e) {
			System.out.println("Error in sendServerVersionMessage: ");
			e.printStackTrace();
		}
	}

	/**
	 * Send a message to tell the client that the server is waiting for a query
	 */
	public void sendReadyForQueryMessage() {
		try {
			this.dataOutputStream_.writeByte('Z');
			this.dataOutputStream_.writeInt(5);
			this.dataOutputStream_.writeByte('I');
		} catch (IOException e) {
			System.out.println("Error in sendReadyForQueryMessage: ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param row
	 */
	public void sendRowDescription(QueryResult row) {
		try {
			short fieldsNo = (short)row.getAttributes().length;
			LinkedList<byte[]> bNameList = new LinkedList<byte[]>();
			// If the field can be identified as a column of a specific table,
			// the
			// object ID of the table; otherwise zero.
			int identificator = 0;
			// If the field can be identified as a column of a specific table,
			// the
			// attribute number of the column; otherwise zero.
			short identificatorAtr = 0;
			// The object ID of the field's data type.
			List<Type> typeIndList = new ArrayList<Type>();
			// The type modifier (see pg_attribute.atttypmod). The meaning of
			// the
			// modifier is type-specific.
			int typeMod = -1;
			// The format code being used for the field. Currently will be zero
			// (text) or one (binary). In a RowDescription returned from the
			// statement variant of Describe, the format code is not yet known
			// and
			// will always be zero.
			short formatCode = 0;

			int totalSize = 6;

			// Null terminate all column names
			for (int i = 0; i < row.getAttributeTypes().length; i++) {
				typeIndList.add(row.getAttributeTypes()[i]);
				byte[] bName = nullTerminateString(row.getAttributes()[i]);
				bNameList.add(bName);
				totalSize += bName.length;
			}

			totalSize += 18 * row.getAttributeTypes().length;

			this.dataOutputStream_.writeByte('T');
			this.dataOutputStream_.writeInt(totalSize);
			this.dataOutputStream_.writeShort(fieldsNo);

			short typeLen = 0;
			int typeInd = 0;
			for (int i = 0; i < row.getAttributeTypes().length; i++) {
				this.dataOutputStream_.writeBytes(new String(bNameList.get(i)));
				this.dataOutputStream_.writeInt(identificator);
				this.dataOutputStream_.writeShort(identificatorAtr);
				switch(typeIndList.get(i)){
				case STRING:
					typeLen = -1;
					typeInd = 25;
					break;
				case INT:
					typeLen = 4;
					typeInd = 23;
					break;
				case REAL:
					typeLen = 4;
					typeInd = 23;
					break;
				}
				this.dataOutputStream_.writeInt(typeInd);
                this.dataOutputStream_.writeShort(typeLen);
				this.dataOutputStream_.writeInt(typeMod);
				this.dataOutputStream_.writeShort(formatCode);
			}
		} catch (IOException e) {
			System.out.println("Error in sendRowDescription: ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param columns
	 */
	public void sendRowDescription(String[] columns) {
		try {
			short fieldsNo = (short) columns.length;
			LinkedList<byte[]> bNameList = new LinkedList<byte[]>();
			// If the field can be identified as a column of a specific table,
			// the
			// object ID of the table; otherwise zero.
			int identificator = 0;
			// If the field can be identified as a column of a specific table,
			// the
			// attribute number of the column; otherwise zero.
			short identificatorAtr = 0;
			// The object ID of the field's data type.
			int typeInd = 0;
			// The data type size (see pg_type.typlen). Note that negative
			// values
			// denote variable-width types.
			short typeLen = -2;
			// The type modifier (see pg_attribute.atttypmod). The meaning of
			// the
			// modifier is type-specific.
			int typeMod = -1;
			// The format code being used for the field. Currently will be zero
			// (text) or one (binary). In a RowDescription returned from the
			// statement variant of Describe, the format code is not yet known
			// and
			// will always be zero.
			short formatCode = 0;

			int totalSize = 6;

			// Null terminate all column names
			for (int i = 0; i < columns.length; i++) {
				String name = columns[i];
				byte[] bName = nullTerminateString(name);
				bNameList.add(bName);
				totalSize += bName.length;
			}

			totalSize += 18 * columns.length;

			this.dataOutputStream_.writeByte('T');
			this.dataOutputStream_.writeInt(totalSize);
			this.dataOutputStream_.writeShort(fieldsNo);

			for (int i = 0; i < columns.length; i++) {
				this.dataOutputStream_.writeBytes(new String(bNameList.get(i)));
				this.dataOutputStream_.writeInt(identificator);
				this.dataOutputStream_.writeShort(identificatorAtr);
				this.dataOutputStream_.writeInt(typeInd);
				this.dataOutputStream_.writeShort(typeLen);
				this.dataOutputStream_.writeInt(typeMod);

				this.dataOutputStream_.writeShort(formatCode);
			}
		} catch (IOException e) {
			System.out.println("Error in sendRowDescription: ");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void sendCommandCompleteMessage() {
		try {
			this.dataOutputStream_.writeByte('C');
			byte[] tmp = this.nullTerminateString("SELECT 1");
			this.dataOutputStream_.writeInt(4 + tmp.length);
			this.dataOutputStream_.write(tmp);
		} catch (IOException e) {
			System.out.println("Error in sendCommandCompleteMessage: ");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param values
	 */
	public void sendDataRow(String[] values) {
		try {
			// 4 bytes to communicate the lenght of the message + 2 bytes for
			// the
			// column numbers = 6
			int tLen = 6;
			short num = (short) values.length;
			LinkedList<Integer> lenColList = new LinkedList<Integer>();
			LinkedList<byte[]> bvalList = new LinkedList<byte[]>();
			byte[] val;

			// Sum the length of the column value
			for (int i = 0; i < values.length; i++) {
				val = values[i].getBytes();
				lenColList.add(val.length);
				bvalList.add(values[i].getBytes());
				// lenght of the value + 4 bytes to communicate the value lenght
				tLen += val.length + 4;
			}

			this.dataOutputStream_.writeByte('D');
			this.dataOutputStream_.writeInt(tLen);
			this.dataOutputStream_.writeShort(num);

			// for each value, send 4 bytes for the value lenght and n bytes for
			// the value itself
			for (int i = 0; i < values.length; i++) {
				this.dataOutputStream_.writeInt(lenColList.get(i));

				this.dataOutputStream_.writeBytes(new String(
						nullTerminateString(values[i])));
			}
		} catch (IOException e) {
			System.out.println("Error in sendDataRow: ");
			e.printStackTrace();
		}
	}

	
	public void sendDataRow(QueryResult row){
		try {
			// 4 bytes to communicate the lenght of the message + 2 bytes for
			// the
			// column numbers = 6
			for(int i=0; i < row.getData().size(); i++){
			
			int tLen = 6;
			short num = (short) row.getData().get(i).length;
			LinkedList<Integer> lenColList = new LinkedList<Integer>();
			LinkedList<byte[]> bvalList = new LinkedList<byte[]>();
			byte[] val;

			// Sum the length of the column value
			for (int j = 0; j < row.getData().get(i).length; j++) {
				val = row.getData().get(i)[j].getBytes();
				lenColList.add(val.length);
				bvalList.add(row.getData().get(i)[j].getBytes());
				// lenght of the value + 4 bytes to communicate the value lenght
				tLen += val.length + 4;
			}

			this.dataOutputStream_.writeByte('D');
			this.dataOutputStream_.writeInt(tLen);
			this.dataOutputStream_.writeShort(num);

			// for each value, send 4 bytes for the value lenght and n bytes for
			// the value itself
			for (int j = 0; j < row.getData().get(i).length; j++) {
				this.dataOutputStream_.writeInt(lenColList.get(j));

				this.dataOutputStream_.writeBytes(new String(
						nullTerminateString(row.getData().get(i)[j])));
			}
			}
		} catch (IOException e) {
			System.out.println("Error in sendDataRow: ");
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * 
	 */
	public void flush() {
		try {
			this.dataOutputStream_.flush();
		} catch (IOException e) {
			System.out.println("Error in flush: ");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param authMessage
	 */
	public void sendAuthenticationOkMessage(AuthEnum authMessage) {
		try {
			this.dataOutputStream_.writeByte('R');
			switch (authMessage) {
			case AuthOK:
				this.dataOutputStream_.writeInt(8);
				this.dataOutputStream_.writeInt(0);
				break;
			case KerberosV5Required:
				this.dataOutputStream_.writeInt(8);
				this.dataOutputStream_.writeInt(2);
				break;
			case ClearTextPasswordRequired:
				this.dataOutputStream_.writeInt(8);
				this.dataOutputStream_.writeInt(3);
				break;
			case MD5EncryptedPasswordRequired:
				/*
				 * needs to implement a salt for the password, we can use
				 * something like: final Random r = new SecureRandom(); byte[]
				 * salt = new byte[4]; r.nextBytes(salt); // String encodedSalt
				 * = Base64.encodeBase64String(salt);
				 */
				throw new NotImplementedException();
			}
		} catch (IOException e) {
			System.out.println("Error in sendAuthenticationOkMessage: ");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void sendBindCompleteMessage() {
		try {
			this.dataOutputStream_.writeByte('2');
			this.dataOutputStream_.writeInt(4);
		} catch (IOException e) {
			System.out.println("Error in sendBindCompleteMessage: ");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void sendEmptyQueryResponseMessage() {
		try {
			this.dataOutputStream_.writeByte('I');
			this.dataOutputStream_.writeInt(4);
		} catch (IOException e) {
			System.out.println("Error in sendEmptyQueryResponseMessage: ");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void sendTerminateMessage() {
		try {
			this.dataOutputStream_.writeByte('X');
			this.dataOutputStream_.writeInt(4);
		} catch (IOException e) {
			System.out.println("Error in sendTerminateMessage: ");
			e.printStackTrace();
		}
	}
}
