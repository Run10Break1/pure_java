package mathpix;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class ObjectMigration {
	
	abstract List<UpdatingTarget> before();
	abstract void after(List<UpdatingTarget> updatingTargets, boolean isSuccess);
	
	public void execute() {
		List<UpdatingTarget> updatingTargets = before();
		if(updatingTargets == null || updatingTargets.isEmpty()) {
			return;
		}
		
		boolean isSuccess = true;
		try {
			for(UpdatingTarget updatingTarget : updatingTargets) {
				List<URLComponent> components = decompose(updatingTarget.content);
				for(URLComponent component : components) {
					component.migrate();
				}
				updatingTarget.updatedContent = recompose(updatingTarget.content, components);
			}
		} catch(Exception e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			after(updatingTargets, isSuccess);
		}
	}
	
	private List<URLComponent> decompose(String s) {
		
		final List<URLComponent> components = new ArrayList<>();
		
		final Pattern imgURLPattern = Pattern.compile("<img[ ]+src=\"(?<url>.*?)\"");
		final Matcher imgURLMatcher = imgURLPattern.matcher(s);
		
		while(imgURLMatcher.find()) {
			String url = imgURLMatcher.group("url");
			int start = imgURLMatcher.start("url");
			int end = imgURLMatcher.end("url");
			
			URLComponent c = new ImgURLComponent(url, start, end);
			components.add(c);
		}
		
		return components;
	}
	
	private String recompose(String s, List<URLComponent> components) {
		StringBuilder sb = new StringBuilder(s);
		
		for(URLComponent component : components) {
			sb = sb.replace(component.start(), component.end(), component.getUpdatedURL());
		}
		
		return sb.toString();
	}
}