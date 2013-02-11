package Compiler.TellstickReplay;

/**
 * @author Per Fransman
 *
 */
public class TellstickDevice {
	private final int id;
	private String title;
	private final String model;
	private final String protocol;
	private String description;
	private final TellstickActions[] supported;
	
	public TellstickDevice( int _id, String _title, String _model, String _protocol, String _description, TellstickActions[] _supported ) {
		this.id = _id;
		this.title = _title;
		this.model = _model;
		this.protocol = _protocol;
		this.description = _description;
		this.supported = _supported;
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMode() {
		return model;
	}
	
	public String getProtocol() {
		return protocol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public TellstickActions[] getSupported() {
		return supported;
	}
}