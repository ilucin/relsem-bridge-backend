package com.etk.parser;

import java.util.ArrayList;

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
	 * Returns the arrayList of the names of the columns if and only if the
	 * query is correct. It throws and excetion in case the query is incorrect.
	 * 
	 * @return The arrayList of the names of the columns
	 * @throws RelSemBridgeParserException
	 *             Means that the query is incorrect and the exception has a
	 *             significant message with the motivation
	 */
	public ArrayList<String> getColumnsName()
			throws RelSemBridgeParserException;
}
