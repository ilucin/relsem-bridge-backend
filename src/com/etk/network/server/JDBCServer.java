package com.etk.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JDBCServer {

	private static int port = 5000;

	// TODO implement max number of connections?

	// Listen for incoming connections and handle them
	public static void main(String[] args) {

		boolean connected_ = false;

		try {
			ServerSocket socket = new ServerSocket(port);
			System.out.println("server started!");
			while (true) {
			Socket server = socket.accept();
				System.out.println("connection accepted");
				ConnectionHandler connectionHandler = new ConnectionHandler(
							server);
					Thread connection = new Thread(connectionHandler);
					connection.start();
					
					//Til here is ok, but suddenly boum
					SessionHandler sessionHandler = new SessionHandler(server);
					Thread session = new Thread(sessionHandler);
					session.start();
				
			}

		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		}
	}

}
