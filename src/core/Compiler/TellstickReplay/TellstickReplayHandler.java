package Compiler.TellstickReplay;

import com.sun.jna.Native;

/**
 * @author Per Fransman
 *
 */
public class TellstickReplayHandler {
	
	private TellstickLibrary libTelldus = null;
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
					this.libTelldus = (TellstickLibrary)Native.loadLibrary("telldus-core", TellstickLibrary.class);
					this.setRunning(true);
					this.setCanRunGui(false);
					break;
				case Windows7:
					this.libTelldus = (TellstickLibrary)Native.loadLibrary("TelldusCore", TellstickLibrary.class);
					this.setRunning(true);
					this.setCanRunGui(true);
					break;
				case Windows8:
					this.libTelldus = (TellstickLibrary)Native.loadLibrary("TelldusCore", TellstickLibrary.class);
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
		
		try{
			this.setScheduler(new TellstickScheduler(this.libTelldus));
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
