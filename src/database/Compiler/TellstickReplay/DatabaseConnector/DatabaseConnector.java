/**
 * 
 */
package Compiler.TellstickReplay.DatabaseConnector;

/**
 * @author Mnemonic
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
	}
	
	/**
	 * Devired Constructor. Takes three parameters to build connection string.
	 * @param _database
	 * @param _uid
	 * @param _pwd
	 */
	public DatabaseConnector( String _database, String _uid, String _pwd ){
		this.setDatabase(_database);
		this.setUid(_uid);
		this.setPwd(_pwd);
	}
	
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
	 * @return the connection
	 */
	public String getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the query
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
