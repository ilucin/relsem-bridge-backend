package com.etk.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ConnectionHandler implements Runnable {

	private Socket server_;
	private Sender sender_;
	private Receiver receiver_;
	private final String pass_ = "postgres";
	private ServerSocket socket_;
	
	
	
	public ConnectionHandler(Socket server, ServerSocket socket) {
		this.server_ = server;
		this.socket_ = socket;
		try {
			this.sender_ = new Sender(new DataOutputStream(
					server_.getOutputStream()));
			this.receiver_ = new Receiver(new DataInputStream(
					server_.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		
		try {
			DataInputStream dataInputStream = new DataInputStream(
					server_.getInputStream());

			MsgParser msgParser = new MsgParser();

			this.receiver_.receiveAuthMessage();

			// ask for the password
			this.sender_
					.sendAuthenticationOkMessage(Sender.AuthEnum.ClearTextPasswordRequired);
			this.sender_.flush();

			String password = this.receiver_.getPassword();
			System.out.println("Password: " + password);

			if (!password.equals(this.pass_)) {
				this.sender_.sendErrorResponse("Wrong Password!");
				return;
			}

			this.sender_.sendAuthenticationOkMessage(Sender.AuthEnum.AuthOK);
			this.sender_.sendServerVersionMessage();
			this.sender_.sendReadyForQueryMessage();
			this.sender_.flush();
			
		
				//Socket server = socket_.accept();
//			while(true){
//				DataInputStream dataInputStreamSession = new DataInputStream(
//						server_.getInputStream());
//				SessionHandler sessionHandler = new SessionHandler(server_, dataInputStreamSession);
//				Thread session = new Thread(sessionHandler);
//				session.start();
//			}
			
			
			
		SessionHandler sessionHandler = new SessionHandler(server_);
		Thread session = new Thread(sessionHandler);
		session.start();
	
		
		
		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}