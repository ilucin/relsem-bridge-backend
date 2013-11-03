/**
 * JWResultSet - It implements java.sql.ResultSet. This class acts as the client 
 * ResultSet. It communicates with the remote ResultSet.
 */


package com.jw.client;

import java.rmi.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import com.jw.server.*;

public abstract class JWResultSet implements java.sql.ResultSet
{
	//Remote ResultSet
	private IRemoteResultSet remoteResultSet;
	
	//Map of column index to column names in the ResultSet
	Hashtable columnList = null;
	
	//The current ResultSet data row 
	private   Object[]   row;

	/**
	 * Constructor for creating the JWResultSet with IRemoteResultSet
	 */
	public JWResultSet(IRemoteResultSet rsInstance) throws SQLException
	{
		remoteResultSet = rsInstance;
		try
		{
			//get the Map of column index to names
			columnList = remoteResultSet.getColumnList();
		}
		catch(Exception ex)
		{
			
		}	
	}

	/**
	 * This method gets the Next data row from the remote ResultSet
	 * It return false if all the data has already been iterated
	 */
	public boolean next() throws SQLException
	{
		try
		{
			//get the current data row from remote ResultSet
			//All the getXXX methods will get data from local 'row' object
			row = remoteResultSet.getNextRow();
		}
		catch(Exception ex)
		{
			return false;		
		}	
		
		if(row == null)
		{
			return false;
		}
		
		return true;
	}	

	/**
	 * This method closes the remote ResultSet
	 */
	public void close()	throws SQLException
	{
		try
		{
			//close the remote ResultSet
			remoteResultSet.close();
		}
		catch(RemoteException ex)
		{
			throw(new SQLException(ex.getMessage()));
		}
	}
	
	///////////////////////////////////////////////////////////
	// getXXX data Methods from the ResultSet  
	
	public String getString(int columnIndex)
					 throws SQLException
	{
		Object columnData = row[columnIndex-1];

		if(columnData == null)
		{
			return null;
		}
		else
		{	
			String str = (String)columnData;
			return   str;
		}
	}

	public String getString(String columnName)
				 throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		Object columnData = row[index.intValue()-1];
		if(columnData == null)
		{
			return null;
		}
		else
		{
			String str = (String)columnData;
			return   str;
		}
	}

	public float getFloat(int columnIndex)
			   throws SQLException
	{
		if(row[columnIndex-1]==null)
		{
			return 0;
		}
		else
		{
			String flotObj = (String)row[columnIndex-1];
			Float flot = Float.valueOf(flotObj);
			return flot.floatValue();
		}
	}
	
	public float getFloat(String columnName)
			   throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
		{
			return 0;
		}
		else
		{
			String flotObj = (String)row[(index.intValue())-1];
			Float flot = Float.valueOf(flotObj);
			return flot.floatValue();
		}
	}
	
	public int getInt(int columnIndex)
		throws SQLException
	{
		if(row[columnIndex-1]==null)
		{
			return 0;
		}
		else
		{
			String currentObj =(String)row[columnIndex-1];
			Integer current = Integer.valueOf(currentObj);
			return current.intValue();
	    }
	}
	
	public int getInt(String columnName)
			   throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
		{
		   	return 0;
		}
		else
		{
			String currentObj = (String)row[(index.intValue())-1];
			Integer current = Integer.valueOf(currentObj);
			return current.intValue();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	//might be put as Not Supported
	public boolean getBoolean(int columnIndex)
					   throws SQLException
	{
		if(row[columnIndex-1] == null)
		{
			return false;
		}
		else
		{
			String boolObj = (String)row[columnIndex-1];
			Boolean bool= Boolean.valueOf(boolObj);
			return bool.booleanValue();
		}
	}

	public byte getByte(int columnIndex)
				 throws SQLException
	{
		if(row[columnIndex-1]==null)
		{
			return 0;
		}
		else
		{
			String byeObj =(String)row[columnIndex-1];
			Byte bye= Byte.valueOf(byeObj);
			return bye.byteValue();
		}
	}

	public short getShort(int columnIndex)
				   throws SQLException
	{
		if(row[columnIndex-1]==null)
		{
			return 0;
		}
		else
		{
			String sortObj = (String)row[columnIndex-1];
			Short sort = Short.valueOf(sortObj);
			return sort.shortValue();
	    }
	}

	public long getLong(int columnIndex)
					 throws SQLException
	{
		if(row[columnIndex-1]==null)
		{
			   return 0;
		}
		else
		{
			String langObj = (String)row[columnIndex-1];
			Long lang = Long.valueOf(langObj);
			return lang.longValue();
		}
	}

	public double getDouble(int columnIndex)
				 throws SQLException
	{
		if(row[columnIndex-1]==null)
		{
			return 0;
		}
		else
		{
			String dubObj = (String)row[columnIndex-1];
			Double dub = Double.valueOf(dubObj);
			return dub.doubleValue();
	    }
	}

	public BigDecimal getBigDecimal(int columnIndex,int scale)
						 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}
	
	public byte[] getBytes(int columnIndex)
					throws SQLException
	{
		if(row[columnIndex-1]==null)
			return null;

		byte Array[] = (byte[])row[columnIndex-1];
		return Array;
	}

	public java.sql.Date getDate(int columnIndex)
				 throws SQLException
	{
		if(row[columnIndex-1]==null)
			return null;

		String datObj = (String)row[columnIndex-1];
		java.sql.Date dat = java.sql.Date.valueOf(datObj);
		return dat;
	}

	public java.sql.Time getTime(int columnIndex)
			 throws SQLException
	{
    	if(row[columnIndex-1]==null)
			return null;

		String timObj = (String)row[columnIndex-1];
		java.sql.Time tim = java.sql.Time.valueOf(timObj);
		return tim;
	}

	public java.sql.Timestamp getTimestamp(int columnIndex)
		   throws SQLException
	{
		if(row[columnIndex-1]==null)
			return null;

		String timstmpObj = (String)row[columnIndex-1];
		java.sql.Timestamp timstmp = java.sql.Timestamp.valueOf(timstmpObj);
		return timstmp;
	}

	public InputStream getAsciiStream(int columnIndex)
						   throws SQLException
	{
		if(row[columnIndex-1]==null)
			return null;

		byte[] byteArray = (byte[])row[columnIndex-1];
		InputStream inStrm = new ByteArrayInputStream(byteArray);
		return inStrm;
	}

	public InputStream getUnicodeStream(int columnIndex)
							 throws SQLException
	{
		if(row[columnIndex-1]==null)
			return null;

		byte[] byteArray = (byte[])row[columnIndex-1];
		InputStream inStrm = new ByteArrayInputStream(byteArray);
		return inStrm;
	}
	
	public InputStream getBinaryStream(int columnIndex)
							throws SQLException
	{
		if(row[columnIndex-1]==null)
			return null;

		byte[] byteArray = (byte[])row[columnIndex-1];
		InputStream inStrm = new ByteArrayInputStream(byteArray);
		return inStrm;
	}

	public Object getObject(int columnIndex)
				throws SQLException
	{
		Object obj = (Object)row[columnIndex-1];
		return obj;
	}

	public BigDecimal getBigDecimal(int columnIndex)
				throws SQLException
	{
		if(row[columnIndex-1]==null)
			return null;

		String bigdStr = (String)row[columnIndex-1];
		Long bigdObj = Long.valueOf(bigdStr);
		BigDecimal  bigd = BigDecimal.valueOf(bigdObj.longValue());
	    return bigd;
	}
	
	public boolean getBoolean(String columnName)
			   throws SQLException
	{
		Integer index= (Integer) columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
		{
			return false;
		}
		else
		{
			String currentObj = (String)row[(index.intValue())-1];
			Boolean current= Boolean.valueOf(currentObj);
			return current.booleanValue();
		}
	}

	public byte getByte(String columnName)
			 throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
		{	
			return 0;
		}	
		else
	    {
			String byeObj = (String)row[(index.intValue())-1];
			Byte bye = Byte.valueOf(byeObj);
			return bye.byteValue();
		}
	}

	public short getShort(String columnName)
			   throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
		{	
			return 0;
		}			
		else
		{
	  		String sortObj = (String)row[(index.intValue())-1];
			Short sort = Short.valueOf(sortObj);
			return sort.shortValue();
	    }
	}

	public long getLong(String columnName)
				 throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
		{
			return 0;
		}
		else
		{
			String langObj = (String)row[(index.intValue())-1];
			Long lang = Long.valueOf(langObj);
			return lang.longValue();
		}
	}

	public double getDouble(String columnName)
					 throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
		{
			return 0;
		}
		else
		{
			String dubObj = (String)row[(index.intValue())-1];
			Double dub = Double.valueOf(dubObj);
				return dub.doubleValue();
		}
	}

	public BigDecimal getBigDecimal(String columnName,int scale)
						 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}
	
	public byte[] getBytes(String columnName)
				throws SQLException
	{
		Integer index = (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
		{
			return null;
		}
		else
		{
			byte Array[] = (byte[])row[(index.intValue())-1];
			return Array;
		}
	}

	public java.sql.Date getDate(String columnName)
				 throws SQLException
	{
	    Integer index = (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
			return null;

		String dateObj =(String)row[(index.intValue())-1];
		java.sql.Date data = java.sql.Date.valueOf(dateObj);
		return data;
	}

	public Time getTime(String columnName)
			 throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
				return null;

		String timObj =(String)row[(index.intValue())-1];
		java.sql.Time tim = java.sql.Time.valueOf(timObj);
		return tim;
	}

	public java.sql.Timestamp getTimestamp(String columnName)
					   throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
			return null;

		String timstmpObj =(String)row[(index.intValue())-1];
		java.sql.Timestamp timstmp = java.sql.Timestamp.valueOf(timstmpObj);
		return timstmp;
	}

	public Object getObject(String columnName)
				 throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		Object obj = (Object)row[(index.intValue())-1];
		return obj;
	}

	public BigDecimal getBigDecimal(String columnName)
				 throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
			return null;

		String bigdStr = (String)row[(index.intValue())-1];
		Long bigdObj = Long.valueOf(bigdStr);
		BigDecimal  bigd = BigDecimal.valueOf(bigdObj.longValue());
	    return bigd;
	}
	
	public InputStream getAsciiStream(String columnName)
			   throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
		  return null;

		byte[] byteArray = (byte[])row[(index.intValue())-1];
		InputStream inStrm = new ByteArrayInputStream(byteArray);
		return inStrm;
	}

	public InputStream getUnicodeStream(String columnName)
							 throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
			return null;

		byte[] byteArray = (byte[])row[(index.intValue())-1];
		InputStream inStrm = new ByteArrayInputStream(byteArray);
		return inStrm;
	}
	
	public InputStream getBinaryStream(String columnName)
							throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
			return null;

		byte[] byteArray = (byte[])row[(index.intValue())-1];
		InputStream inStrm = new ByteArrayInputStream(byteArray);
		return inStrm;
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

	public String getCursorName()
					 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public ResultSetMetaData getMetaData()
							  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int findColumn(String columnName)
				   throws SQLException
	{
		Integer index= (Integer) columnList.get(columnName);
		  return index.intValue();
	}

	public Reader getCharacterStream(int columnIndex)
						  throws SQLException
	{
		if(row[columnIndex-1]==null)
			return null;

		byte[] byteArray = (byte[])row[columnIndex-1];
		Reader rdrStream = new InputStreamReader(new ByteArrayInputStream(byteArray));
		return rdrStream;
	}

	public Reader getCharacterStream(String columnName)
						  throws SQLException
	{
		Integer index= (Integer)columnList.get(columnName);
		if(row[(index.intValue())-1]==null)
			return null;

		byte[] byteArray = (byte[])row[(index.intValue())-1];
		Reader rdrStream = new InputStreamReader(new ByteArrayInputStream(byteArray));
		return rdrStream;
	}

	public boolean isBeforeFirst()
					  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean isAfterLast()
						throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean isFirst()
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean isLast()
			   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void beforeFirst()
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void afterLast()
			   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean first()
			  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean last()
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int getRow()
			   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean absolute(int row)
					 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean relative(int rows)
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean previous()
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

	public int getFetchSize()
					 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int getType()
				throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public int getConcurrency()
					   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean rowUpdated()
				   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean rowInserted()
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean rowDeleted()
					   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateNull(int columnIndex)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateBoolean(int columnIndex,boolean x)
					   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateByte(int columnIndex, byte x)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateShort(int columnIndex,short x)
					 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateInt(int columnIndex,int x)
				   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateLong(int columnIndex,long x)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateFloat(int columnIndex,float x)
					 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateDouble(int columnIndex,double x)
				  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateBigDecimal(int columnIndex,BigDecimal x)
						  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateString(int columnIndex,String x)
					  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateBytes(int columnIndex,byte[] x)
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateDate(int columnIndex,java.sql.Date x)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateTime(int columnIndex,Time x)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateTimestamp(int columnIndex,Timestamp x)
						 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateBinaryStream(int columnIndex,InputStream x,int length)
							throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateCharacterStream(int columnIndex,Reader x,int length)
							   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateObject(int columnIndex,Object x,int scale)
					  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateObject(int columnIndex,Object x)
					  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateNull(String columnName)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateByte(String columnName, byte x)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateShort(String columnName, short x)
					 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateInt(String columnName,int x)
				   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateLong(String columnName,long x)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateFloat(String columnName, float x)
					 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateDouble(String columnName,double x)
					  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateBigDecimal(String columnName,BigDecimal x)
						  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateString(String columnName,String x)
					  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateBytes(String columnName,byte[] x)
					 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateDate(String columnName,java.sql.Date x)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateTime(String columnName, Time x)
					throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateTimestamp(String columnName,Timestamp x)
						 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateAsciiStream(String columnName,InputStream x,int length)
						   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateBinaryStream(String columnName,InputStream x,int length)
							throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateCharacterStream(String columnName,Reader reader,int length)
							   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateObject(String columnName,Object x,int scale)
				  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateObject(String columnName,Object x)
					  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void insertRow() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void updateRow()throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void deleteRow()  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void refreshRow()  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void cancelRowUpdates() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void moveToInsertRow() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public void moveToCurrentRow() throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Statement getStatement()  throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}


	public java.sql.Date getDate(int columnIndex,Calendar cal)
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public java.sql.Date getDate(String columnName,Calendar cal)
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Time getTime(int columnIndex,Calendar cal)
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Time getTime(String columnName,Calendar cal)
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Timestamp getTimestamp(int columnIndex,Calendar cal)
						   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Timestamp getTimestamp(String columnName,Calendar cal)
						   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public boolean wasNull()throws SQLException
    {
		throw(new SQLException("Not Supported"));
    }

	public void updateBoolean(String columnName, boolean x)
	                   throws SQLException
    {
		throw(new SQLException("Not Supported"));
    }


	public void updateAsciiStream(int columnIndex, InputStream x, int length)
	                       throws SQLException
    {
		throw(new SQLException("Not Supported"));
    }


/////////////////////////////////////////////////////////////////////////////  
//	These method would have to be implemented for JDK1.2 and higher
	
	public Object getObject(int i, Map map)
						 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Ref getRef(int i) throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Blob getBlob(int i) throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Clob getClob(int i) throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Array getArray(int i) throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Object getObject(String colName, Map map)
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Ref getRef(String colName)
					   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Blob getBlob(String colName)
						 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}

	public Clob getClob(String colName)
				 throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}
	public Array getArray(String colName)
						   throws SQLException
	{
		throw(new SQLException("Not Supported"));
	}
}