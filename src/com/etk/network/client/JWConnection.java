/**
* JWConnection - This class implements the java.sql.Connection interface and acts as a
* Client connection. It communicates with the Remote connection.
*/

package com.jw.client;

import java.sql.*;
import java.util.*;
import java.rmi.*;
import com.jw.server.*;

public class JWConnection implements Connection
{
	//Remote connection
	private IRemoteConnection  remoteConnection;
	
	/**
	 * constructor for creating the JWConnection instance with IRemoteConnection
	 */
	public JWConnection(IRemoteConnection remCon)
	{
		remoteConnection = remCon;
	}


	/**
	 * This method creates a remote statement and then returns JWStatement 
	 * object holding the remote statement
	 */
	public Statement createStatement()
	     throws SQLException
	{
		try
		{
			IRemoteStatement remStmt = (IRemoteStatement)remoteConnection.createStatement();
			JWStatement localStmtInstance = new JWStatement(remStmt);
			return (Statement)localStmtInstance;
		
		}		
		catch(RemoteException ex)
		{
			throw(new SQLException("RemoteException:" + ex.getMessage()));
		}
		catch(Exception ex)
		{
			throw(new SQLException("RemoteException:" + ex.getMessage()));
		}
	}

	/**
	 * This method closes the remote Connection
	 */
	public void close() throws SQLException
	{
		try
		{
		 	remoteConnection.closeConnection();
		}
		catch(RemoteException ex)
		{
			throw ((new SQLException("RemoteException:" + ex.getMessage())));
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	//Not supported methods
	public String nativeSQL(String sql)
	 	throws SQLException
	{
	 	throw(new SQLException("Not Supported"));
	}

	 public void setAutoCommit(boolean autoCommit)
	 	throws SQLException
	{
	 	throw(new SQLException("Not Supported"));
	}

	public boolean getAutoCommit()
	 	throws SQLException
	{
	 	throw(new SQLException("Not Supported"));
	}

	public void commit() throws SQLException
	{
	 	throw(new SQLException("Not Supported"));
	}

	public void rollback() throws SQLException
	{
	 	throw(new SQLException("Not Supported"));
	}

	public boolean isClosed()throws SQLException
	{
			throw(new SQLException("Not Supported"));
	}

	public DatabaseMetaData getMetaData()
         throws SQLException
	{
			throw(new SQLException("Not Supported"));
	}

	public void setReadOnly(boolean readOnly)
	      throws SQLException
	{
			throw(new SQLException("Not Supported"));
	}

	public boolean isReadOnly()
	       throws SQLException
	{
			throw(new SQLException("Not Supported"));
	}

	public void setCatalog(String catalog)
           throws SQLException
	{
			throw(new SQLException("Not Supported"));
	}

	public String getCatalog()
	     throws SQLException
	{
			throw(new SQLException("Not Supported"));
	}
	public void setTransactionIsolation(int level)
         throws SQLException
	{
			throw(new SQLException("Not Supported"));
	}

	public int getTransactionIsolation()
	      throws SQLException
	{
			throw(new SQLException("Not Supported"));
	}

	public SQLWarning getWarnings()
	      throws SQLException
	{
			 throw(new SQLException("Not Supported"));
	}

	public void clearWarnings()
	      throws SQLException
	{
			 throw(new SQLException("Not Supported"));
	}

	public PreparedStatement prepareStatement(String sql)
	              throws SQLException
	{
		   		 throw(new SQLException("Not Supported"));
	}

	public CallableStatement prepareCall(String sql)
		          throws SQLException
	{
		   	   	 throw(new SQLException("Not Supported"));
	}
	
	public PreparedStatement prepareStatement(String sql,int resultSetType,int resultSetConcurrency)
	         throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public CallableStatement prepareCall(String sql,int resultSetType,int resultSetConcurrency)
	        throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Statement createStatement(int resultSetType,int resultSetConcurrency)
	         throws SQLException
    {
		throw(new SQLException("Not Supported"));
	}

	/////////////////////////////////////////////////////////////
	//These method would have to be implemented for JDK1.2 and higher
	
	public void setTypeMap(Map map) throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}
	
	public Map getTypeMap() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}
}







