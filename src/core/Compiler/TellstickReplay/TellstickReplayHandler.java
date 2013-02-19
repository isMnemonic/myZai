package Compiler.TellstickReplay;

import Compiler.TellstickReplay.Webservice.TellstickReplayWebService;

import com.sun.jna.Native;
import javax.xml.ws.Endpoint;

/**
 * @author Per Fransman
 *
 */
public class TellstickReplayHandler {
	
	private TellstickLibrary library = null;
	private TellstickScheduler scheduler = null;
	private boolean isRunning = false;
	private boolean canRunGui = false;

	/**
	 * Description: Main constructor.
	 * @param os
	 */
	public TellstickReplayHandler(TellstickSystems os) {
		try {
			switch (os){
				case Linux:
					this.library = (TellstickLibrary)Native.loadLibrary("telldus-core", TellstickLibrary.class);
					this.setRunning(true);
					this.setCanRunGui(false);
					break;
				case Windows7:
					this.library = (TellstickLibrary)Native.loadLibrary("TelldusCore", TellstickLibrary.class);
					this.setRunning(true);
					this.setCanRunGui(true);
					break;
				case Windows8:
					this.library = (TellstickLibrary)Native.loadLibrary("TelldusCore", TellstickLibrary.class);
					this.setRunning(true);
					this.setCanRunGui(true);
					break;
				case Mac:
					System.out.println("Operating system not supported. Yet.");
					break;
				default:
					System.out.println("Operating system not supported. Yet.");
					break;
			}
		}
		catch( Exception e ) {
			//throw e;
			System.out.println( e );
		}
		
		/**
		 * Initiate the scheduler.
		 */
		try{
			this.setScheduler(new TellstickScheduler(this.library));
			System.out.println("Done preparing scheduler.");
		}
		catch( Exception e ){
			System.out.println( e );
		}
		
		/**
		 *  Publish the webservice to the tomcat server.
		 */
		try{
			Endpoint.publish("http://localhost:9090/TellstickReplay", new TellstickReplayWebService(this.library));
			System.out.println("Done publishing web service.");
		}
		catch( Exception e ){
			System.out.println( e );
		}
	}

	/**
	 * @return the boolean isRunning.
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * @param isRunning the value to set.
	 */
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	/**
	 * @return the boolean CanRunGui.
	 */
	public boolean getCanRunGui() {
		return canRunGui;
	}

	/**
	 * @param canRunGui the value to set.
	 */
	public void setCanRunGui(boolean canRunGui) {
		this.canRunGui = canRunGui;
	}

	/**
	 * @return the scheduler.
	 */
	public TellstickScheduler getScheduler() {
		return this.scheduler;
	}

	/**
	 * @param scheduler the scheduler to set.
	 */
	public void setScheduler(TellstickScheduler scheduler) {
		this.scheduler = scheduler;
	}
}
