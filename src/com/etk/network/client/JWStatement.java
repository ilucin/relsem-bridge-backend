/**
 * JWStatement - It implements java.sql.Statement. This class acts as the client 
 * Statement. It communicates with the remote Statement.
 */

package com.jw.client;

import java.sql.*;
import java.util.*;
import java.rmi.*;
import com.jw.server.*;

public class JWStatement implements java.sql.Statement
{
	//Remote Statement
	private IRemoteStatement remoteStmt;

	/**
	 * Constructor for creating the JWStatement
	 */
	public JWStatement(IRemoteStatement stmt)
	{
		remoteStmt = stmt;
	}

	/**
	 * This method executes the SQL query via Remote Statement and then
	 * returns the JWResultSet holding remote ResultSet.
	 */
	public ResultSet executeQuery(String sqlQuery)
	  throws SQLException
	{
		try
		{
			IRemoteResultSet remoteRsInstance = (IRemoteResultSet)remoteStmt.executeQuery(sqlQuery);
			JWResultSet localRsInstance = new JWResultSet(remoteRsInstance);
			return (ResultSet)localRsInstance;
		}
		catch(RemoteException ex)
		{
			throw(new SQLException(ex.getMessage()));
		}
	}

	/**
	 * This method executes the SQL data write/modify statement via Remote Statement 
	 */
	public int executeUpdate(String sqlQuery)
		  throws SQLException
	{
		try
		{
			int updateCount = remoteStmt.executeUpdate(sqlQuery);
			return updateCount;
		}
		catch(RemoteException ex)
		{
			throw(new SQLException(ex.getMessage()));
		}
	}

	/**
	 * This method closes the Remote Statement 
	 */
	public void close() throws SQLException
	{
		try
		{
			remoteStmt.close();
		}
		catch(RemoteException ex)
		{
			throw(new SQLException(ex.getMessage()));
		}
	}

	////////////////////////////////////////////////////////////////////////////////////
	//Not supported methods
	
	public int getMaxFieldSize() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void setMaxFieldSize(int max)
		throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int getMaxRows() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void setMaxRows(int max)
		throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void setEscapeProcessing(boolean enable)
			throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int getQueryTimeout()throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void setQueryTimeout(int seconds)
		 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void cancel() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public SQLWarning getWarnings() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void clearWarnings() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void setCursorName(String name)
						   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean execute(String sql)
		  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public ResultSet getResultSet()
	  			   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int getUpdateCount()
	  			   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean getMoreResults()
			throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void setFetchDirection(int direction)
			throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int getFetchDirection()
	                      throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void setFetchSize(int rows)
	  				throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int getFetchSize() throws SQLException
	{
	   throw(new SQLException("Not Supported"));
	}

	public int getResultSetConcurrency()
	  						   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int getResultSetType() throws SQLException
	{
  		throw(new SQLException("Not Supported"));
	}

	public void addBatch(String sql)
		throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void clearBatch()
		throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int[] executeBatch()
		   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Connection getConnection()
		 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}
}
