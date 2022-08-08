package g33_ceng211_hw1;


public class Issue {
	
	private int id;
	private int memberId;
	private String bookId;
	private String issueDate;
	private String returningDate;
	
	public Issue(int id, int memberId, String bookId, String issueDate, String returningDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.returningDate = returningDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(String returningDate) {
		this.returningDate = returningDate;
	}
	
	public String toString() {
		return "Issue: " + "ID= " + id +", MemberID= " + memberId + ", BookID= " + bookId 
				+ ", Issue Date= " + issueDate +", Returning Date= " + returningDate;
	}
	
	
}
