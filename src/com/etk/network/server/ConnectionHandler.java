package com.etk.network.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;


public class ConnectionHandler implements Runnable {

	private Socket server_;
	private Sender sender_;
	private Receiver receiver_;
	private final String pass_ = "postgres";
	
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
		
		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
