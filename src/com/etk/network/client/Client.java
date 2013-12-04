package com.etk.network.client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Client {

	public static void main(String[] args) {
		new Client();
	}

	public Client() {
		Connection conn = null;
		ArrayList<Student> list = new ArrayList<Student>();

		// connect to the database
		conn = connectToDatabaseOrDie();
        System.out.println("Connected!");
        
        // get data
		query(conn, list);
		
		System.out.println("QuerySent!");
		// print results
		printAll(list);
	}

	private void printAll(ArrayList<Student> list) {
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	private void query(Connection conn, ArrayList<Student> list) {
		try {
			Statement st = conn.createStatement();
			// the syntax for FROM is schema.table
			ResultSet rs = st
					.executeQuery("SELECT id FROM student.student");
			while (rs.next()) {
				String name = rs.getString("name");
                System.out.println(name);
                String surname = rs.getString("surname");
                System.out.println(surname);
               // Date date = rs.getDate("date");
                //System.out.println(date.toString());
             
                
            }
			rs.close();
			st.close();
		} catch (SQLException se) {
			System.err.println("Threw a SQLException.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
	}

	private Connection connectToDatabaseOrDie() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			String host = "127.0.0.1";
            String database = "Test";
            String username = "postgres";
            String password = "postgres";
            String url = "jdbc:postgresql://localhost:5000/dbname";
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.err.println("I have not found the PostgreSQL driver class");
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
		return conn;
	}

}
