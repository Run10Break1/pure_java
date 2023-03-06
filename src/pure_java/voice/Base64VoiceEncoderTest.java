package pure_java.voice;



public class Base64VoiceEncoderTest {

	public static void main(String args[]) {
		
		Base64VoiceEncoder o = new Base64VoiceEncoder();
		
		final String filePath = "C:\\Users\\LG\\Downloads\\output.pcm";
		System.out.println(o.encode(filePath));
	}
}
