/**
 * 
 */
package Compiler.TellstickReplay.DatabaseConnector;

/**
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Per Fransman
 *
 */
public class DatabaseConnector {
	
	private String url;
	private String database;
	private String uid;
	private String pwd;
	private String query;
	private Connection connection;
	
	/**
	 * 	Default Constructor. Assuming default values from installation.
	 */
	public DatabaseConnector() {
		this.setDatabase("TellstickReplay");
		this.setUid("tellstick");
		this.setPwd("replay");
		this.setUrl("jdbc:mysql://192.168.1.1:3306/TellstickReplay");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(this.url);
		} catch (ClassNotFoundException e) {
			// TODO : Update logging
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	 * @param query : String containing the SQL query.
	 * @return 'Resultset' with the result from the query execution.
	 */
	public ResultSet ExecuteQuery( String query ) {
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = this.connection.createStatement();
			result = statement.executeQuery(query);
		}
		catch( Exception e ){
			//throw e;
			System.out.println( e );
		}
		return result;
	}

	/**
	 * Method: getConnection.
	 * @return 'String' value of the current connection.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Method: setConnection. Sets the connection towards the database to work with.
	 * @param connection the connection to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
