package g33_ceng211_hw1;

import java.text.ParseException;

public class LibraryManagementApp {
	
	private static FıleIO fileIO = new FıleIO();
	 

	public static void main(String[] args) throws ParseException {
		Library library = fileIO.readBooks();  //Returns Library object that contains Books (One-Dimensional Array)
		LibraryManagement libraryManagement = fileIO.readIssues(); //Returns LibraryManagement..
																//object that contains Issues for each Library.. 
																//within a Two-Dimensional Array
		Member[] members = fileIO.readMembers();
		LibraryQuery libraryQuery = new LibraryQuery(members, library, libraryManagement);
		// Necessary methods to respond the following queries in LibraryQuery class:
		libraryQuery.getMostIssuedBook();
		libraryQuery.memberOfMostIssuedBook();
		libraryQuery.printHighestPenalty();
		libraryQuery.getMostCopiedBook();
		libraryQuery.fewestCopiedBook();
		libraryQuery.memberOfLeastIssuedBookInCSLibrary();
	}
	
}