/**
 * IRemoteDriver - This interface exposes the basic Driver method remotly. 
 */
package com.jw.server;

import java.rmi.*;
import java.sql.*;

public interface IRemoteDriver extends Remote
{
	IRemoteConnection getConnection() throws RemoteException,SQLException;    
}