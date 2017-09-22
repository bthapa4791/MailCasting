/**
 * 
 */
package com.bimal.dbquery;

/**
 * @author bimalthapa
 *
 */
public class DBQuery {
	
	public static final String createDB = "CREATE DATABASE IF NOT EXISTS ";
	
	public static final String createTableQuery = "CREATE TABLE IF NOT EXISTS USERTABLE "
			+ "(id INT(64) NOT NULL AUTO_INCREMENT UNIQUE,"
			+ "email VARCHAR(100),"
			+ "password VARCHAR(100),"
			+ "name VARCHAR(100),"
			+ "gender VARCHAR(100),"
			+ "contact VARCHAR(100),"
			+ "country VARCHAR(100), PRIMARY KEY (id))";
	
	public static final String registerQuery = "INSERT INTO USERTABLE (email, password, name, gender,"
			+ "contact, country) VALUES(?, ?, ?, ?, ?, ?)";

	public static final String loginQuery = "SELECT * FROM USERTABLE WHERE email = ? AND password = ?";

	public static final String createInboxQuery = "CREATE TABLE IF NOT EXISTS INBOXTABLE "
			+ "(id INT(64) NOT NULL AUTO_INCREMENT UNIQUE,"
			+ "date VARCHAR(64),"
			+ "sender VARCHAR(100),"
			+ "receiver VARCHAR(100),"
			+ "msg VARCHAR(300), PRIMARY KEY (id))";
	
	public static final String insertMsgQuery = "INSERT INTO INBOXTABLE (date, sender, receiver, msg)"
			+ "VALUES(?, ?, ?, ?)";
	
	public static final String retriveInboxQuery = "SELECT * FROM INBOXTABLE WHERE sender = ?";
	
	public static final String deleteMailQuery = "DELETE FROM INBOXTABLE WHERE id = ?";
	
}
