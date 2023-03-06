package mathpix;

public class UpdatingTarget {
	
	public String tableName;
	public String Id;
	public String content;
	public String updatedContent;
	
	public UpdatingTarget(String tableName, String Id, String content) {
		this.tableName = tableName;
		this.Id = Id;
		this.content = content;
	}
}
