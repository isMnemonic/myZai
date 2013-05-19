package Compiler.TellstickReplay;

/**
 * @author Per Fransman
 *
 */
public class Core {
	
	/**
	 * Method: Core. Main constructor.
	 */
	public Core() {
		
	}
	
	/**
	 * Method: Main. Program start from console. Primary used in console enviroments.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Initiatin Tellstick Replay Core.");
			String _system = System.getProperty("os.name");
			_system = _system.replaceAll("\\s","");
			TellstickSystems os = TellstickSystems.valueOf( _system );
			TellstickReplayHandler handler = new TellstickReplayHandler( os );
			while(handler.isRunning()) { }
			System.out.println( "Exiting. Bye.." );
			System.exit(0);
		}
		catch( Exception e ) {
			System.out.println( e );
		}
	}
	
	//TODO: Iniator for desktop enviroments.
}
