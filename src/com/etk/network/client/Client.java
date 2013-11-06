package com.etk.network.client;

import java.sql.*;
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

		// get data
		query(conn, list);

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
					.executeQuery("SELECT id, name, surname FROM student.student");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				list.add(new Student(id, name, surname));
			}
			rs.close();
			st.close();
		} catch (SQLException se) {
			System.err.println("Threw a SQLException.");
			System.err.println(se.getMessage());
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
            String url = "jdbc:postgresql:5000//" + host + "/" + database;
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
