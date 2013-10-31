/**
 * RemoteConnectionImpl - This class performs the role of main RMI server in Type-III
 * Driver. The client driver connects to the object of this class via RMI and then gets 
 * the Connection. 
 */

package com.jw.server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.sql.*;

public class RemoteDriverImpl extends UnicastRemoteObject
	implements IRemoteDriver
{
	//Data Source Name
	private static String DSN;
	//Data Source user
	private static String  dsUser;
	//Data source password
	private static String dsPassword;
	
	public RemoteDriverImpl() throws RemoteException
	{
		super();
  	}

	/**
	 * This is the main starting method of RMI server. It expects
	 * Data Source Name,  Data Source user, Data source password as 
	 * first three arguments.
	 */
	public static void main(String args[])
	{
		System.setSecurityManager(new RMISecurityManager());

		try
		{
			//get the Data Source Name,  Data Source user, Data source password and log level 
			ResourceBundle settingsBundle = ResourceBundle.getBundle("DriverSettings");
			DSN = settingsBundle.getString("DSN");
			dsUser = settingsBundle.getString("User");
			dsPassword = settingsBundle.getString("Password");

			//Creaete an object of RemoteDriverImpl to register with RMI naming service
			//After this the Type-III client driver layer can access this object. 
			RemoteDriverImpl serverInstance = new RemoteDriverImpl();
			Naming.rebind("RemoteDriver",serverInstance);			
			
			//Load the JDBC-ODBC bridge driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//Wait for close server command
			System.out.println();
			System.out.println("Remote Driver server has started successfully...");
			System.out.println();
			System.out.println("Press 'Y' to stop the server...");
			
			while(System.in.read() != 'Y')
			{	
			}
			
			System.out.println("Closing the remote server");
			System.exit(0);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();	
		}
	}

	/**
	 * This method creates a JDBC-ODBC connection and then returns a reference 
	 * to the remote interface of the RemoteConnectionImpl object holding 
	 * JDBC-ODBC connection.
	 */
	public IRemoteConnection getConnection() throws RemoteException,SQLException
	{
		String URL="jdbc:odbc:"+DSN;
		Connection sqlCon = DriverManager.getConnection(URL,dsUser,dsPassword);
		RemoteConnectionImpl ConnectionInstance = new RemoteConnectionImpl(sqlCon);
		return (IRemoteConnection)ConnectionInstance;
	}
}