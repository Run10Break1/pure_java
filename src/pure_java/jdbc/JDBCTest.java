package pure_java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDBCTest {
	
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String url = "jdbc:mysql://edulab-db.ck48eaulnxuh.ap-northeast-2.rds.amazonaws.com:3306/soopulae_prod?useUniCode=yes&CharacterEncoding=UTF-8";
	static final String user = "edulabAdmin";
	static final String password = "edulab97^^";
		
	public static void main(String args[]) {
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName(driver);
			
			// 2. DB서버 연결
			Connection conn = DriverManager.getConnection(url, user, password);
			
			// 3. SQL 실행 통로 형성
			Statement stmt = conn.createStatement();
			
			final String sql = "SELECT contents AS c FROM quiz WHERE contents LIKE '%img%' LIMIT 10 OFFSET 0";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			final List<String> contents = new ArrayList<>();
			while(rs.next()) {
				String content = rs.getString("c");
				contents.add(content);
			}
			
			for(String content : contents) {
				System.out.println(extractUrls(content));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static List<String> extractUrls(String text) {
		final Pattern pattern = Pattern.compile("<img[ ]+src=\"(?<url>.*?)\"");
		Matcher matcher = pattern.matcher(text);
		
		List<String> urls = new ArrayList<>();
		while(matcher.find()) {
			String url = matcher.group("url");
			if(url == null) continue;
			
			urls.add(url);
		}
		
		return urls;
	}
}

class ImageObject<ID> {
	final String table;
	final ID id;
	final String url;
	
	byte [] file;
	String fileName;
	
	public ImageObject(String table, ID id, String url) {
		this.table = table;
		this.id = id;
		this.url = url;
	}
}