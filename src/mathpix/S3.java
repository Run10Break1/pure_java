package mathpix;

import java.io.File;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;




public class S3 {

	private final String ACCESS_KEY = "AKIAVBURKMF3GOLFEZGL";
	private final String SECRET_KEY = "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";
	private final Regions region = Regions.AP_NORTHEAST_2;
	private final String bucket = "soopulae-resources";
	
	private AmazonS3 awsS3;
	
	public S3() {
		AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		awsS3 = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(region)
				.build();
	}
	
	public void upload(File file, String key) {
		uploadToS3(new PutObjectRequest(bucket, key, file));
	}
	
	private void uploadToS3(PutObjectRequest por) {
		try {
			awsS3.putObject(por);
			System.out.println(String.format("[%s] is uploaded", por.getKey()));
		} catch(SdkClientException e) {
			e.printStackTrace();
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	
	
}
