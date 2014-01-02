package com.etk.network.server;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;

import mock.MockSelectObject;
import mock.MockedSchema;

import com.etk.db.DBMSExecutor;
import com.etk.db.QueryExecutorImpl;
import com.etk.db.query.QueryResult;
import com.etk.manager.User;
import com.etk.manager.schema.Schema;
import com.etk.parser.SelectObject;
import com.etk.parser.SelectQueryToObject;

class SessionHandler implements Runnable {
	private Socket server_;
	private Sender sender_;
	private Receiver receiver_;

	public SessionHandler(Socket server) {
		this.server_ = server;
		// this.dataInputStream_ = dataInputStream;
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
			this.receiver_.getMessageType();
			String query = this.receiver_.readParseMessage();
			query = query.substring(0, query.length()-1);
			System.out.println(query);
			// InputStream is = new
			// ByteArrayInputStream(query.getBytes("UTF-8"));
			// SelectQueryToObject transform = new SelectQueryToObject(is);
			// SelectObject selectObject = transform.getSelectObject();

			// InputStream is = new ByteArrayInputStream(
			// inputString.getBytes("UTF-8"));
			// SelectQueryToObject transform = new SelectQueryToObject(is);
			// SelectObject selectObject = transform.getSelectObject();
			//
			// System.out.println("Parser found tables: "
			// + selectObject.getTableNames().toString()
			// + "\nParser found columns: "
			// + selectObject.getColumnNames().toString());

			// SELECTMain.parse(is);

			/*
			 * this is in case the server receive an empty query string and
			 * seems to work sendEmptyQueryResponseMessage(dataOutputStream);
			 * sendReadyForQueryMessage(dataOutputStream);
			 * dataOutputStream.flush();
			 */

			//InputStream is = new ByteArrayInputStream(query.getBytes("UTF-8"));
			//SelectQueryToObject selectQueryToObject = new SelectQueryToObject(
			//		is);
			//SelectObject selectObject = selectQueryToObject.getSelectObject();
			
			SelectObject selectObject = new MockSelectObject();
			
			User user = new User("marko");
			Schema schema = new MockedSchema(user);

			DBMSExecutor qExec = new QueryExecutorImpl(schema);

			List<QueryResult> queryResultList = qExec
					.executeQuery(selectObject);

			// getColumnNames from parser

			// Type[] types = queryResultList.get(0).getAttributeTypes();
			// String[] columns = queryResultList.get(0).getAttributes();

			// String[] columns = { "name", "surname" };
			this.sender_.sendRowDescription(queryResultList.get(0));

			for (int i = 0; i < queryResultList.get(0).getData().size() ; i++) {
				this.sender_.sendDataRow(queryResultList.get(0).getData()
						.get(i));
			}

			// this.sender_.sendDataRow(queryResultList.get(0).getData().get(0));
			// this.sender_.sendDataRow(queryResultList.get(0).getData().get(1));
			// this.sender_.sendDataRow(queryResultList.get(0).getData().get(2));
			// this.sender_.sendDataRow(queryResultList.get(0).getData().get(3));
			// this.sender_.sendDataRow(queryResultList.get(0).getData().get(4));
			// this.sender_.sendDataRow(queryResultList.get(0).getData().get(5));
			// this.sender_.sendDataRow(queryResultList.get(0).getData().get(6));
			// this.sender_.sendDataRow(queryResultList.get(0).getData().get(7));

			// for (int i = 0; i < queryResultList.size(); i++) {
			// QueryResult queryResult = queryResultList.get(i);
			// this.sender_.sendDataRow(queryResult.getAttributes());
			// this.sender_.flush();
			// }

			// List<String> values = new ArrayList<String>();
			// values.add("david");
			// values.add("riobo");
			// this.sender_.sendDataRow(values);

			this.sender_.sendCommandCompleteMessage(queryResultList.get(0).getData().size());
			this.sender_.sendReadyForQueryMessage();
			this.sender_.flush();

			SessionHandler sessionHandler = new SessionHandler(server_);
			Thread session = new Thread(sessionHandler);
			session.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
