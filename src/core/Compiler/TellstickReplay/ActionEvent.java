/**
 * 
 */
package Compiler.TellstickReplay;

import Compiler.TellstickReplay.TellstickActions;

/**
 * @author Per Fransman @ Compiler
 *
 */
public class ActionEvent extends java.util.EventObject {
	
	private TellstickActions action = null;
	private TellstickDevice device = null;
	private Object value = null;

	public ActionEvent(Object source, TellstickActions action, TellstickDevice device, Object value) {
		super(source);
		this.action = action;
		this.device = device;
		this.value = value;
	}
	
	public TellstickActions getTellstickAction() {
		return this.action;
	}
	
	public void setTellstickAction(TellstickActions _action) {
		this.action = _action;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the device
	 */
	public TellstickDevice getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(TellstickDevice device) {
		this.device = device;
	}

}
