/**
 * RemoteConnectionImpl - This class contains the actual JDBC-ODBC connection. 
 * It acts as a remote wrapper over the JDBC-ODBC connection.
 */

package com.jw.server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.sql.*;
import java.io.*;

public class  RemoteConnectionImpl extends UnicastRemoteObject
	implements IRemoteConnection
{

	//The actual JDBC-ODBC connection
	private Connection sqlConnection;

	/**
	 * Constructor to create RemoteConnectionImpl with JDBC-ODBC connection
	 */
	public RemoteConnectionImpl(Connection sqlCon) throws RemoteException
	{
		super();
		sqlConnection = sqlCon;
	}

	/**
	 * This method creates the JDBC-ODBC statement and then returns reference to 
	 * the interface of RemoteStatementImpl object holding JDBC-ODBC statement.
	 */
	public IRemoteStatement createStatement() throws RemoteException,SQLException
	{
		RemoteStatementImpl StmtImplInstance =  new RemoteStatementImpl(sqlConnection.createStatement());
		return  (IRemoteStatement)StmtImplInstance;
	}
	
	/**
	 * This method closes the JDBC-ODBC connection
	 */
	public void closeConnection() throws RemoteException,SQLException
	{
		sqlConnection.close();		
	}	
}