package mathpix;

import java.sql.SQLException;
import java.util.List;

public class ExistingObjectMigration extends ObjectMigration {
	
	private DB db;
	
	int offset = 0;
	int limit = 1;
	
	private String tableName;
	private String IdColName;
	private String contentColName;
	
	public ExistingObjectMigration(String tableName, String IdColName, String contentColName) throws ClassNotFoundException, SQLException {
		this.tableName = tableName;
		this.IdColName = IdColName;
		this.contentColName = contentColName;
		db = new DB();
	}

	@Override
	List<UpdatingTarget> before() {
		try {
			final List<UpdatingTarget> updatingTargets = db.query(tableName, IdColName, contentColName, limit, offset);

			return updatingTargets;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	void after(List<UpdatingTarget> updatingTargets, boolean isSuccess) {
		System.out.println(isSuccess);
	}
}
