package mathpix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {

	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://edulab-db.ck48eaulnxuh.ap-northeast-2.rds.amazonaws.com:3306/soopulae_prod?useUniCode=yes&CharacterEncoding=UTF-8";
	private final String user = "edulabAdmin";
	private final String password = "edulab97^^";
	
	private Connection conn;
	
	public DB() throws ClassNotFoundException, SQLException {
		// 1. JDBC Driver 로딩
		Class.forName(driver);
				
		// 2. DB서버 연결
		conn = DriverManager.getConnection(url, user, password);
	}
	
	public List<UpdatingTarget> query(String tableName, String IdColName, String contentColName, int limit, int offset) throws SQLException {
		// 3. SQL 실행 통로 형성
		Statement stmt = conn.createStatement();
		
		final String sql = String.format(
				"SELECT %s as Id, %s as content FROM %s WHERE %s LIKE '%%img%%' LIMIT %d OFFSET %d", 
				IdColName, contentColName, tableName, contentColName, limit, offset);
		
		ResultSet rs = stmt.executeQuery(sql);
		
		final List<UpdatingTarget> queryResults = new ArrayList<>();
		while(rs.next()) {
			String Id = rs.getString("Id");
			String content = rs.getString("content");
			
			UpdatingTarget queryResult = new UpdatingTarget(tableName, Id, content);
			queryResults.add(queryResult);
		}
		
		return queryResults;
	}
}
