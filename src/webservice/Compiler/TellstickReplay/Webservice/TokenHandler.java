/**
 * 
 */
package Compiler.TellstickReplay.Webservice;

/**
 * @author Per Fransman
 *
 */
final class TokenHandler {
	private final String PUBLIC_KEY;
	private final String PRIVATE_KEY;
	private final String TOKEN;
	private final String TOKEN_SECRET;
	
	/**
	 * Description: Main constructor.
	 * @param Public_Key
	 * @param Private_Key
	 * @param Token
	 * @param Token_Secret
	 */
	public TokenHandler( String Public_Key, String Private_Key, String Token, String Token_Secret) {
		this.PUBLIC_KEY = Public_Key;
		this.PRIVATE_KEY = Private_Key;
		this.TOKEN = Token;
		this.TOKEN_SECRET = Token_Secret;
	}

	/**
	 * 
	 * @return
	 */
	public String getPUBLIC_KEY() {
		return PUBLIC_KEY;
	}

	/**
	 * 
	 * @return
	 */
	public String getPRIVATE_KEY() {
		return PRIVATE_KEY;
	}

	/**
	 * 
	 * @return
	 */
	public String getTOKEN() {
		return TOKEN;
	}

	/**
	 * 
	 * @return
	 */
	public String getTOKEN_SECRET() {
		return TOKEN_SECRET;
	}
}