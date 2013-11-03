/**
 * IRemoteConnection - This interface exposes the basic Connection methods remotely
 */
package com.jw.server;

import java.rmi.*;
import java.sql.*;

public interface IRemoteConnection extends Remote
{
	IRemoteStatement createStatement() throws RemoteException,SQLException;
	void closeConnection() throws RemoteException,SQLException;
}