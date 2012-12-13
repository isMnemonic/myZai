package Compiler.TellstickReplay;

import Compiler.TellstickReplay.TellstickSystems;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * @author Mnemonic
 *
 */
public class TellstickReplayHandler {
	
	private CLibrary libTelldus;
	private boolean isRunning;
	private boolean canRunGui;

	public TellstickReplayHandler(TellstickSystems os) {
		try {
			switch (os){
				case Linux:
					this.libTelldus = (CLibrary)Native.loadLibrary("telldus-core", CLibrary.class);
					this.setRunning(true);
					this.setCanRunGui(false);
					break;
				case Windows7:
					this.libTelldus = (CLibrary)Native.loadLibrary("TelldusCore", CLibrary.class);
					this.setRunning(true);
					this.setCanRunGui(true);
					break;
				case Windows8:
					this.libTelldus = (CLibrary)Native.loadLibrary("TelldusCore", CLibrary.class);
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
	}
	
	public void TellstickReplayThreadHandler(){
		
	}
	
	public boolean CheckDeviceFeatures( int id ){
		boolean value = false;
		try {
			libTelldus.tdInit();
			
			libTelldus.tdClose();
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}
	
	public boolean DimDeviceById( int id ) {
		boolean value = false;
		try {
			libTelldus.tdInit();
			
			libTelldus.tdClose();
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}
	
	public boolean DimDeviceByGroup( String name ) {
		boolean value = false;
		try {
			libTelldus.tdInit();
			
			libTelldus.tdClose();
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}
	
	public boolean TurnDeviceOffById( int id ){
		boolean value = false;
		try {
			libTelldus.tdInit();
			
			libTelldus.tdClose();
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}
	
	public boolean TurnDeviceOnById( int id ){
		boolean value = false;
		try {
			libTelldus.tdInit();
			
			libTelldus.tdClose();
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public boolean getCanRunGui() {
		return canRunGui;
	}

	public void setCanRunGui(boolean canRunGui) {
		this.canRunGui = canRunGui;
	}
}
