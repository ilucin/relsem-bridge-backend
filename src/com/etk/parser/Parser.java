package com.etk.parser;

public interface Parser {
	/**
	 * Check the validity of a query
	 * 
	 * @param query
	 *            The query to parse
	 * @return True if and only if the query is correct, false otherwise
	 */
	public boolean checkValidity(String query);

	/**
	 * Returns the arrayList of the names of the columns only if the query is
	 * correct. Returns an empty arraylist if the query is incorrect.
	 * 
	 * @return The arrayList of the names of the columns, an empty string if the
	 *         query is incorrect
	 */
	// TODO maybe is better to throw an exception in case the query is
	// incorrect?
	public ArrayList<String> getColumnsName();

	/**
	 * Is used to know which is the error of the parser in case of a bad query
	 * 
	 * @return The String with the error message
	 * @throws Exception
	 *             In case the query is correct and there is no error message to
	 *             read
	 */
	//TODO define a more significant exception
	public String getErrorMessage() throws Exception;
}
