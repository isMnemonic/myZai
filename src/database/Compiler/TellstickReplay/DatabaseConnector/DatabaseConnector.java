/**
 * 
 */
package Compiler.TellstickReplay.DatabaseConnector;

import com.mysql.*;
import com.mysql.jdbc.*;

/**
 * @author Per Fransman
 *
 */
public class DatabaseConnector {
	
	private String connection;
	private String database;
	private String uid;
	private String pwd;
	private String query;
	
	/**
	 * 	Default Constructor. Assuming default values from installation.
	 */
	public DatabaseConnector() {
		this.setDatabase("TellstickReplay");
		this.setUid("tellstick");
		this.setPwd("replay");
		this.setConnection("jdbc:mysql://192.168.1.1:3306/TellstickReplay");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO : Update logging
			e.printStackTrace();
		}
	}
	
	/**
	 * Devired Constructor. Takes three parameters to build connection string.
	 * @param _database
	 * @param _uid
	 * @param _pwd
	 */
	public DatabaseConnector( String _database, String _uid, String _pwd ) {
		this.setDatabase(_database);
		this.setUid(_uid);
		this.setPwd(_pwd);
	}
	
	/**
	 * Executes supplied query against the database.
	 * @param _query
	 * @return boolean value 'true' if the query returned rows >= 1 or
	 * 'false' if rows are <= 0.
	 */
	public boolean ExecuteQuery( String _query ) {
		boolean value = false;
		try {
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}

	/**
	 * Method: getConnection.
	 * @return 'String' value of the current connection.
	 */
	public String getConnection() {
		return connection;
	}

	/**
	 * Method: setConnection. Sets the connection towards the database to work with.
	 * @param connection the connection to set
	 */
	public void setConnection(String connection) {
		this.connection = connection;
	}

	/**
	 * Method: getDatabase.
	 * @return 'String' value of the current database.
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * Method: setDatabase. Sets the default database supplied in the parameter.
	 * @param database
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * Method: getUid.
	 * @return 'String' value of the current user id.
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * Method: setUid. Sets the user id supplied in the parameter.
	 * @param uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * Method: getPwd.
	 * @return 'String' value of the current password.
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Method: setPwd. Sets the user password supplied in the parameter.
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Method: getQuery
	 * @return 'String' value of the current set query.
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

}
