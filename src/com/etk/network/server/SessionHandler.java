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
		try {
			this.sender_ = new Sender(new DataOutputStream(
					server_.getOutputStream()));
			this.receiver_ = new Receiver(new DataInputStream(
					server_.getInputStream()));
		} catch (IOException e) {
			System.out.println("Error getting streams: ");
			e.printStackTrace();
			return;
		}
	}

	public void run() {
		try {
			char type = this.receiver_.getMessageType();
			System.out.println(type);

			if (type == 'Q' || type == 'P') {

				String query = this.receiver_.readQueryMessage();
				System.out.println(query);

				InputStream is = new ByteArrayInputStream(
						query.getBytes("UTF-8"));

				SelectQueryToObject selectQueryToObject = new SelectQueryToObject(
						is);
				SelectObject selectObject = selectQueryToObject
						.getSelectObject();

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
				 * seems to work
				 * sendEmptyQueryResponseMessage(dataOutputStream);
				 * sendReadyForQueryMessage(dataOutputStream);
				 * dataOutputStream.flush();
				 */

				// InputStream is = new
				// ByteArrayInputStream(query.getBytes("UTF-8"));
				// SelectQueryToObject selectQueryToObject = new
				// SelectQueryToObject(
				// is);
				// SelectObject selectObject =
				// selectQueryToObject.getSelectObject();

				// SelectObject selectObject = new MockSelectObject();

				User user = new User("marko");
				Schema schema = new MockedSchema(user);

				DBMSExecutor qExec = new QueryExecutorImpl(schema);

				List<QueryResult> queryResultList = qExec
						.executeQuery(selectObject);

				this.sender_.sendRowDescription(queryResultList.get(0));

				for (int i = 0; i < queryResultList.get(0).getData().size(); i++) {
					this.sender_.sendDataRow(queryResultList.get(0).getData()
							.get(i));
				}

				this.sender_.sendCommandCompleteMessage(queryResultList.get(0)
						.getData().size());
				this.sender_.sendReadyForQueryMessage();
				this.sender_.flush();

				SessionHandler sessionHandler = new SessionHandler(server_);
				Thread session = new Thread(sessionHandler);
				session.start();
			} else
				sender_.sendErrorResponse("Type message not supported, try it again");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
