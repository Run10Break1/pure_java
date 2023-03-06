package mathpix;

public abstract class URLComponent {
	
	protected final String URL;
	protected final int start;
	protected final int end;
	protected String updatedURL;
	
	public URLComponent(String URL, int start, int end) {
		this.URL = URL;
		this.start = start;
		this.end = end;
	}
	
	public int start() {
		return start;
	}
	
	public int end() {
		return end;
	}

	public String getUpdatedURL() {
		return updatedURL;
	}
	
	void migrate() {
		updatedURL = URL;
	}
	
}
