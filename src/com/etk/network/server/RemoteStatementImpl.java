/**
 * RemoteStatementImpl - This class contains the actual JDBC-ODBC statement.
 * It acts as a remote wrapper over the JDBC-ODBC statement.
 */
package com.jw.server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.sql.*;
import java.io.*;

public class RemoteStatementImpl extends UnicastRemoteObject
	implements IRemoteStatement
{

	//JDBC-ODBC statement
	private Statement sqlStatment;

	/**
	 * Constructor for RemoteStatementImpl with JDBC-ODBC Statement
	 */
	public RemoteStatementImpl(Statement sqlStmt) throws RemoteException
	{
		super();
		sqlStatment = sqlStmt;
	}

	/**
	 * This method gets a JDBC-ODBC ResultSet and then returns a reference 
	 * to the remote interface of the RemoteResultSetImpl object holding 
	 * JDBC-ODBC ResultSet.
	 */
	public IRemoteResultSet executeQuery(String Query) throws RemoteException,SQLException
	{
		ResultSet rs = sqlStatment.executeQuery(Query);
		RemoteResultSetImpl remoteRs = new RemoteResultSetImpl(rs);
		return (IRemoteResultSet)remoteRs;
	}

	/**
	 * This method executest the data modify statement
	 */
	public int executeUpdate(String Query) throws RemoteException,SQLException
	{
		return sqlStatment.executeUpdate(Query);
	}

	/**
	 * This method closes the JDBC-ODBC Statement
	 */
	public void close() throws RemoteException,SQLException
	{
		sqlStatment.close();
	}
}