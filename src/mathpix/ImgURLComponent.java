package mathpix;


public class ImgURLComponent extends URLComponent {
	
	private S3 s3;

	public ImgURLComponent(String url, int start, int end, S3 s3) {
		super(url, start, end);
		this.s3 = s3;
	}

	void migrate() {
		
	}
}
