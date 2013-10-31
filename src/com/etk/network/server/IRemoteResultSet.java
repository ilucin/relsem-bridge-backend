/**
 * IRemoteResultSet - This interface exposes the basic ResultSet methods remotly. 
 */

package com.jw.server;

import java.rmi.*;
import java.util.*;
import java.sql.*;

public interface IRemoteResultSet extends Remote
{	   
	Object[] getNextRow() throws RemoteException,SQLException;
	void close() throws RemoteException,SQLException;
	Hashtable getColumnList() throws RemoteException,SQLException;
}