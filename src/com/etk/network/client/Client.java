package com.etk.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Client {

	private InputStreamReader isr_ = new InputStreamReader(System.in);
	private BufferedReader br_ = new BufferedReader(isr_);

	public static void main(String[] args) {
		new Client();
	}

	public Client() {
		Connection conn = null;
		ArrayList<Student> list = new ArrayList<Student>();

		// connect to the database
		conn = connectToDatabaseOrDie();
		System.out.println("Connected!");
		boolean exit = false;

		while (!exit) {
			System.out.println("Choose option:");
			System.out.println("1-Enter query");
			System.out.println("2-Quit");
			int option = 0;

			try {
				option = Integer.parseInt(br_.readLine());
			} catch (NumberFormatException | IOException e1) {
			}

			switch (option) {
			case 1:

				System.out.println("Write the query: ");
				String query = null;
				try {
					query = br_.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}

				// get data
				query(conn, list, query);

				System.out.println("QuerySent!");
				// print results
				printAll(list);
				break;
			case 2:
				exit = true;
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		}
	}

	private void printAll(ArrayList<Student> list) {
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	private void query(Connection conn, ArrayList<Student> list, String query) {
		try {
			Statement st = conn.createStatement();
			// the syntax for FROM is schema.table
			ResultSet rs = st.executeQuery(query);
			
			// getColumnNames from parser

			String[] columns = { "name", "surname" };
			
			
			int i=0;
			while (rs.next()) {
				String value = rs.getString(columns[i]);
				System.out.println(value);
				i++;
				// Date date = rs.getDate("date");
				// System.out.println(date.toString());

			}
			rs.close();
			st.close();
		} catch (SQLException se) {
			// System.err.println("Threw a SQLException.");
			// System.err.println(se.getErrorCode());
			System.err.println("An error occurred:");
			System.err.println(se.getMessage());
			//se.printStackTrace();
		}
	}

	private Connection connectToDatabaseOrDie() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			String host = "localhost";
			String databaseName = "dbname";
			String username = "postgres";
			String password = "postgres";
			String url = "jdbc:postgresql://" + host + ":5000/" + databaseName;
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.err.println("I have not found the PostgreSQL driver class");
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			System.out.println("Cannot establish a connection!");
			e.printStackTrace();
			System.exit(2);
		}
		return conn;
	}

}
