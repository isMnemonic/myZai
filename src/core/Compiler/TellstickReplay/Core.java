package Compiler.TellstickReplay;

public class Core {
	
	public Core() { }
	
	public static void main(String[] args) {
		try {
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
}
