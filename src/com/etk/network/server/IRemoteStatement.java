/**
 * IRemoteStatement - This interface exposes the basic Statement methods remotely
 */

package com.jw.server;

import java.rmi.*;
import java.sql.*;

public interface IRemoteStatement extends Remote
{
	IRemoteResultSet executeQuery(String Query) throws RemoteException,SQLException;
	int  executeUpdate(String Query) throws RemoteException,SQLException;
	void close() throws RemoteException,SQLException;
}