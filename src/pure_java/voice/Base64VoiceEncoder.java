package pure_java.voice;

import java.io.IOException;
import java.nio.file.*;
import java.util.Base64;

public class Base64VoiceEncoder {

	String encode(String audioFilePath) {
		try {
	        Path path = Paths.get(audioFilePath);
	        byte[] audioBytes = Files.readAllBytes(path);
	        String audioContents = Base64.getEncoder().encodeToString(audioBytes);
	        
	        return audioContents;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
