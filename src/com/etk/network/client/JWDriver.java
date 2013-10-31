/**
* JWDriver - This class implements the java.sql.Driver interface and acts as a
* Client driver. It communicates with the Remote Driver.
* 
* The driver URL is jdbc:JWDriver: + <Remote server name/IP Address>.
* 
* Any Java program can use this driver for JDBC purpose by specifying 
* this URL format.
*/

package com.jw.client;

import java.util.*;
import java.sql.*;
import java.rmi.*;
import com.jw.server.*;
import java.io.*;

public class JWDriver implements java.sql.Driver
{
	//Remote driver
	static IRemoteDriver remoteDriver = null;
	
	//Driver URL prefix.
	private static final String URL_PREFIX = "jdbc:JWDriver:";
	
	private static final int MAJOR_VERSION = 1;
	private static final int MINOR_VERSION = 0;
	
	static
	{
		try
		{
			//Register the JWDriver with DriverManager
			JWDriver driverInst = new JWDriver();
			DriverManager.registerDriver(driverInst);
			
			//System.setSecurityManager(new RMISecurityManager());
		}
		catch(Exception e)
		{}
	}
	
	/**
	 * It returns the URL prefix for using JWDriver
	 */
	public static String getURLPrefix()
	{
		return URL_PREFIX;
	}
	
	/**
	 * This method create a remote connection and then
	 * returns the JWConnection object holdng a Remote Connection
	 */
	public Connection connect(String url,Properties loginProp)
			throws SQLException
	{	
		JWConnection localConInstance = null;
		
		if(acceptsURL(url))
		{			
			try
			{	
				//extract the remote server location coming with URL
				String serverName = url.substring(URL_PREFIX.length(),url.length());
								
				//connect to remote server only if not already connected
				connectRemote(serverName);
				
				//Get the remote Connection
				IRemoteConnection remoteConInstance = (IRemoteConnection)remoteDriver.getConnection();
				
				//Create the local JWConnection holding remote Connenction
				localConInstance = new JWConnection(remoteConInstance);
				
			}
			catch(RemoteException ex)
			{	
				throw(new SQLException(ex.getMessage()));
			}
			catch(Exception ex)
			{
				throw(new SQLException(ex.getMessage()));
			}
		}
					
		return (Connection)localConInstance;
	}
	
	/**
	 * This method makes the one time connection to the RMI server
	 */
	private void connectRemote(String serverName) throws Exception
	{
		try
		{				
			if(remoteDriver == null)
			{	
				remoteDriver = (IRemoteDriver)Naming.lookup("rmi://"+serverName+":1099"+"/RemoteDriver");
			}	
		}
		catch(Exception ex)
		{ 
			throw ex;
		}
	}
	
	/**
	 * This method returns true if the given URL starts with the JWDriver url.
	 * It is called by DriverManager.
	 */
	public boolean acceptsURL(String url)
		   throws SQLException
	{						
		return url.startsWith(URL_PREFIX);
	}	

	public int getMajorVersion()
	{
		return MAJOR_VERSION;
	}

	public int getMinorVersion()
	{
		return MINOR_VERSION;
	}

	public java.sql.DriverPropertyInfo[] getPropertyInfo(String url,Properties loginProps)
		throws SQLException
	{
		return new DriverPropertyInfo[0];
	}

	public boolean jdbcCompliant()
	{
		return false;
	}
}