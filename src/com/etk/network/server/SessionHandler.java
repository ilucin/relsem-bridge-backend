package com.etk.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.etk.db.DBMSExecutor;
import com.etk.db.query.QueryResult;

class SessionHandler implements Runnable {
	private Socket server_;
	private Sender sender_;
	private Receiver receiver_;

	public SessionHandler(Socket server) {
		this.server_ = server;
		try {
			this.sender_ = new Sender(new DataOutputStream(
					server_.getOutputStream()));
			this.receiver_ = new Receiver(new DataInputStream(
					server_.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		try {
			DataInputStream dataInputStream = new DataInputStream(
					server_.getInputStream());

			MsgParser msgParser = new MsgParser();

			// if (dataInputStream.available() > 0) {
			byte type = dataInputStream.readByte();
			int msgLength = dataInputStream.readInt();
			// remove the terminator of the first empty string
			dataInputStream.readByte();
			System.out.println("Message Type: " + (char) type);
			System.out.println("Lenght: " + msgLength);

			// - 4 for the message lenght, - 1 for the terminator of the first
			// string
			// - 1 for the terminator of the first string, - 2 for the number of
			// parameter
			byte[] buf = new byte[msgLength - 4 - 1 - 1 - 2];
			dataInputStream.read(buf);
			String inputString = msgParser.parseMsg(buf);
			System.out.println(inputString);

			// InputStream is = new ByteArrayInputStream(
			// inputString.getBytes("UTF-8"));
			// SelectQueryToObject transform = new SelectQueryToObject(is);
			// SelectObject selectObject = transform.getSelectObject();
			//
			// System.out.println("Parser found tables: "
			// + selectObject.getTableNames().toString()
			// + "\nParser found columns: "
			// + selectObject.getColumnNames().toString());

			// InputStream is = new
			// ByteArrayInputStream(inputString.getBytes("UTF-8"));
			// SELECTMain.parse(is);

			/*
			 * this is in case the server receive an empty query string and
			 * seems to work sendEmptyQueryResponseMessage(dataOutputStream);
			 * sendReadyForQueryMessage(dataOutputStream);
			 * dataOutputStream.flush();
			 */

			DBMSExecutor dbmsExecutor = new DBMSExecutor() {

				@Override
				public List<QueryResult> executeQuery(String sqlQuery) {
					// TODO Auto-generated method stub
					return null;
				}
			};

			List<QueryResult> queryResultList = dbmsExecutor
					.executeQuery(inputString);

			// getColumnNames from parser

			String[] columns = { "name", "surname" };
			this.sender_.sendRowDescription(columns);

			// for (int i = 0; i < queryResultList.size(); i++) {
			// QueryResult queryResult = queryResultList.get(i);
			// this.sender_.sendDataRow(queryResult.getAttributes());
			// this.sender_.flush();
			// }

			List<String> values = new ArrayList<String>();
			values.add("david");
			values.add("riobo");
			this.sender_.sendDataRow(values);

			this.sender_.sendCommandCompleteMessage();
			this.sender_.sendReadyForQueryMessage();
			this.sender_.flush();

		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
