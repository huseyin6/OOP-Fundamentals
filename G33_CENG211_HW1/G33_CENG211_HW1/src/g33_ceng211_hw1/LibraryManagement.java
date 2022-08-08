package g33_ceng211_hw1;


public class LibraryManagement {
	
	private Issue[][] issueObj;      // Two-Dimensional array that holds Issue objects for each Library
	private int numberOfObjects = 0; // initially equals to 0;
	
	public LibraryManagement (int row, int column) {
		issueObj = new Issue[row][column];
	}
	
	public Issue[][] getIssueObj() {
		return issueObj;
	}
	
	public int getNumberOfObjects() {
		return numberOfObjects;
	}

	public void setNumberOfObjects(int numberOfObjects) {
		this.numberOfObjects = numberOfObjects;
	}
	

	public void add(Issue issue, int libraryNumber) {
		issueObj[libraryNumber][numberOfObjects] = issue;
		++numberOfObjects;
	}
	
	public Issue getIssue(int libraryNumber, int obj) {
		return (Issue) issueObj[libraryNumber][obj];
		
	}

}
