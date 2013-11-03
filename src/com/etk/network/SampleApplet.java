/**
 * SampleApplet - This is a test applet that demonstrates the use of the Type-III JWDriver
 */
import java.awt.*;
import java.awt.event.*;import java.applet.*;
import java.io.*;import java.sql.*;
import java.util.*;
import com.jw.client.JWDriver;
public class SampleApplet extends Applet implements ActionListener
{	String msg_ = "";	
	Button btnGetData_;		
	public void init()	{		btnGetData_ = new Button("Get Data");		add(btnGetData_);		btnGetData_.addActionListener(this);
		try
		{	
			//Load the com.jw.client.JWDriver class in Client Browser JVM
			Class.forName("com.jw.client.JWDriver");
		}
		catch(Exception ex)
		{
			msg_ = ex.getMessage();
		}	}
	public void actionPerformed(ActionEvent ae)	{		String str = ae.getActionCommand();
		if(str.equals("Get Data"))
		{			getData();
			repaint();
		}
	}
	
	/**
	 * This method gets the connection from the JWDriver and then gets a ResultSet
	 * from the authors table in pubs database.
	 */
    public void getData()	{		try
		{
			Properties props = new Properties();
			String server = getCodeBase().getHost();			
			//prepare the JWDriver URL		
			String driverProtocol = JWDriver.getURLPrefix() + server;
			
			//get the connection from driver (we are getting a JWConnection from JWDriver)
			Connection conn = DriverManager.getConnection(driverProtocol,props);
			
			//create the statement (we are getting a JWStatement)
			Statement stmt = conn.createStatement();			
			
			//execute the Select query (we are getting a JWResultSet)
			ResultSet rs = stmt.executeQuery("Select au_lname from authors Where au_id = '409-56-7008'");
			//Iterate over the resultset
			if(rs.next())
            {
				msg_ = "Author Last Name: " + rs.getString(1);
				repaint();				
			}

			//Close the ResultSet, Statement, Connection
			rs.close();
			stmt.close();
			conn.close();			
		}
		catch(Exception ex)
		{	
			msg_ += ex.getMessage();
		}	}
	
	//Show the first row results obtained from database    public void paint(Graphics g)
    {		if(!msg_.equals(""))		{	
			g.drawString("Author ID: 409-56-7008", 150, 90);			g.drawString(msg_, 150, 110);		}	
    }
}
