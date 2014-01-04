package com.etk.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectionHandler implements Runnable {

	private Socket server_;
	private Sender sender_;
	private Receiver receiver_;
	private final String pass_ = "postgres";

	public ConnectionHandler(Socket server) {
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

	@Override
	public void run() {
		try {
			if (!this.receiver_.receiveAuthMessage()) {
				this.sender_.sendWeDontManageSSL();
				this.sender_.flush();
				this.receiver_.receiveAuthMessage();
			}

			// ask for the password
			this.sender_
					.sendAuthenticationOkMessage(Sender.AuthEnum.ClearTextPasswordRequired);
			this.sender_.flush();
			
			this.receiver_.getMessageType();
			String password = this.receiver_.getPassword();
			// System.out.println("Password: " + password);

			if (password == null || !password.equals(this.pass_)) {
				this.sender_.sendErrorResponse("Wrong Password!");
				this.sender_.flush();
				return;
			}

			this.sender_.sendAuthenticationOkMessage(Sender.AuthEnum.AuthOK);
			this.sender_.sendServerVersionMessage();
			this.sender_.sendReadyForQueryMessage();
			this.sender_.flush();

			SessionHandler sessionHandler = new SessionHandler(server_);
			Thread session = new Thread(sessionHandler);
			session.start();
		} catch (IOException e) {
			this.sender_
					.sendErrorResponse("Error in the authentication procedure!");
			this.sender_.flush();
			e.printStackTrace();
			return;
		}
	}
}
