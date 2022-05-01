package Notes;

public class Notes {

	private int Id;
    private String Content;
    private int UserId;
    private boolean IsEditable;
    private String UserName;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public boolean isIsEditable() {
		return IsEditable;
	}
	public void setIsEditable(boolean isEditable) {
		IsEditable = isEditable;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	@Override
	public String toString() {
		return "Notes [Id=" + Id + ", Content=" + Content + ", UserId=" + UserId + ", IsEditable=" + IsEditable
				+ ", UserName=" + UserName + "]";
	}
  
}
