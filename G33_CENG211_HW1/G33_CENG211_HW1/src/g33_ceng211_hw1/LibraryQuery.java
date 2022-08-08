package g33_ceng211_hw1;

import java.text.ParseException;
import java.util.Date;

public class LibraryQuery {
	//Fields
	private Member[] members;
	private Library library;
	private LibraryManagement libraryManagement;
	//Constructor
	public LibraryQuery(Member[] members, Library library, LibraryManagement libraryManagement) {
		super();
		this.members = members;
		this.library = library;
		this.libraryManagement = libraryManagement;
	}

	public String getBookId(Issue issue) {
		if(issue == null) {
			return "-1";
		}
		return issue.getBookId();
	}
	
	public void getMostIssuedBook() {
		int numberOfBooksInL1 = 20;
		int numberOfBooksInL2 = 10;
		int numberOfBooksInL3 = 13;

		int numberOfL1Issues = libraryManagement.getIssueObj()[0].length;
		int numberOfL2Issues = libraryManagement.getIssueObj()[1].length;
		int numberOfL3Issues = libraryManagement.getIssueObj()[2].length;

		int mostIssueL1;
		int mostIssueL2;
		int mostIssueL3;
		
		int[] amountOfIssuesForEachBookInLibrary1 = new int[numberOfBooksInL1];
		int[] amountOfIssuesForEachBookInLibrary2 = new int[numberOfBooksInL2];
		int[] amountOfIssuesForEachBookInLibrary3 = new int[numberOfBooksInL3];
		// Firstly, set the index in the corresponding array to 0 .. 
		// for each book corresponding libraries
		for(int i = 0; i < numberOfBooksInL1; i++) {
			amountOfIssuesForEachBookInLibrary1[i] = 0;
		}
		for(int i = 0; i < numberOfBooksInL2; i++) {
			amountOfIssuesForEachBookInLibrary2[i] = 0;
		}
		for(int i = 0; i < numberOfBooksInL3; i++) {
			amountOfIssuesForEachBookInLibrary3[i] = 0;
		}
		// Get bookId for each issue in Library1.. 
		// And increase the indexed bookId in the array 1 by 1..
		// According to the bookId order in the L1_Books.csv file
		for(int j=0; j<numberOfL1Issues;j++) {
			String bookId = getBookId(libraryManagement.getIssueObj()[0][j]);
			if(bookId.equals("R1")) {
				amountOfIssuesForEachBookInLibrary1[0] += 1;
			}else if(bookId.equals("P1")) {
				amountOfIssuesForEachBookInLibrary1[1] += 1;
			}else if(bookId.equals("R2")) {
				amountOfIssuesForEachBookInLibrary1[2] += 1;
			}else if(bookId.equals("R3")) {
				amountOfIssuesForEachBookInLibrary1[3] += 1;
			}else if(bookId.equals("P2")) {
				amountOfIssuesForEachBookInLibrary1[4] += 1;
			}else if(bookId.equals("B1")) {
				amountOfIssuesForEachBookInLibrary1[5] += 1;
			}else if(bookId.equals("B2")) {
				amountOfIssuesForEachBookInLibrary1[6] += 1;
			}else if(bookId.equals("P3")) {
				amountOfIssuesForEachBookInLibrary1[7] += 1;
			}else if(bookId.equals("Fa1")) {
				amountOfIssuesForEachBookInLibrary1[8] += 1;
			}else if(bookId.equals("T1")) {
				amountOfIssuesForEachBookInLibrary1[9] += 1;
			}else if(bookId.equals("Fe1")) {
				amountOfIssuesForEachBookInLibrary1[10] += 1;
			}else if(bookId.equals("R4")) {
				amountOfIssuesForEachBookInLibrary1[11] += 1;
			}else if(bookId.equals("Fe2")) {
				amountOfIssuesForEachBookInLibrary1[12] += 1;
			}else if(bookId.equals("T2")) {
				amountOfIssuesForEachBookInLibrary1[13] += 1;
			}else if(bookId.equals("Fa2")) {
				amountOfIssuesForEachBookInLibrary1[14] += 1;
			}else if(bookId.equals("Fe2")) {
				amountOfIssuesForEachBookInLibrary1[15] += 1;
			}else if(bookId.equals("M1")) {
				amountOfIssuesForEachBookInLibrary1[16] += 1;
			}else if(bookId.equals("Fi1")) {
				amountOfIssuesForEachBookInLibrary1[17] += 1;
			}else if(bookId.equals("H1")) {
				amountOfIssuesForEachBookInLibrary1[18] += 1;
			}else if(bookId.equals("R5")) {
				amountOfIssuesForEachBookInLibrary1[19] += 1;
			}
		}
		// Find the most issued book in L1
		int lengthL1 = amountOfIssuesForEachBookInLibrary1.length;
		mostIssueL1 = amountOfIssuesForEachBookInLibrary1[0];
		int mostIssueL1Index = 0;
		for(int i=1; i<lengthL1; i++) {
			if(mostIssueL1 < amountOfIssuesForEachBookInLibrary1[i]) {
				mostIssueL1 = amountOfIssuesForEachBookInLibrary1[i];
				mostIssueL1Index = i;
			}
		}
		// Get bookId for each issue in Library2.. 
		// And increase the indexed bookId in the array 1 by 1..
		// According to the bookId order in the L2_Books.csv file		
		for(int j=0; j<numberOfL2Issues;j++) {
			String bookId = getBookId(libraryManagement.getIssueObj()[1][j]);
			if (!bookId.equals("-1")) {
				if(bookId.equals("E1")) {
					amountOfIssuesForEachBookInLibrary2[0] += 1;
				}else if(bookId.equals("E2")) {
					amountOfIssuesForEachBookInLibrary2[1] += 1;
				}else if(bookId.equals("E3")) {
					amountOfIssuesForEachBookInLibrary2[2] += 1;
				}else if(bookId.equals("E4")) {
					amountOfIssuesForEachBookInLibrary2[3] += 1;
				}else if(bookId.equals("E5")) {
					amountOfIssuesForEachBookInLibrary2[4] += 1;
				}else if(bookId.equals("E6")) {
					amountOfIssuesForEachBookInLibrary2[5] += 1;
				}else if(bookId.equals("E7")) {
					amountOfIssuesForEachBookInLibrary2[6] += 1;
				}else if(bookId.equals("E8")) {
					amountOfIssuesForEachBookInLibrary2[7] += 1;
				}else if(bookId.equals("E9")) {
					amountOfIssuesForEachBookInLibrary2[8] += 1;
				}else if(bookId.equals("E10")) {
					amountOfIssuesForEachBookInLibrary2[9] += 1;
				}
			}
		}
		// Find the most issued book in L2
		int lengthL2 = amountOfIssuesForEachBookInLibrary2.length;
		mostIssueL2 = amountOfIssuesForEachBookInLibrary2[0];
		int mostIssueL2Index = 0;
		for(int i=1; i<lengthL2; i++) {
			if(mostIssueL2 < amountOfIssuesForEachBookInLibrary2[i]) {
				mostIssueL2 = amountOfIssuesForEachBookInLibrary2[i];
				mostIssueL2Index = i;
			}
		}
		// Get bookId for each issue in Library3.. 
		// And increase the indexed bookId in the array 1 by 1..
		// According to the bookId order in the L3_Books.csv file		
		for(int j=0; j<numberOfL3Issues;j++) {
			String bookId = getBookId(libraryManagement.getIssueObj()[2][j]);
			if (!bookId.equals("-1")) {
				if(bookId.equals("CS1")) {
					amountOfIssuesForEachBookInLibrary3[0] += 1;
				}else if(bookId.equals("CS2")) {
					amountOfIssuesForEachBookInLibrary3[1] += 1;
				}else if(bookId.equals("CS3")) {
					amountOfIssuesForEachBookInLibrary3[2] += 1;
				}else if(bookId.equals("CS4")) {
					amountOfIssuesForEachBookInLibrary3[3] += 1;
				}else if(bookId.equals("CS5")) {
					amountOfIssuesForEachBookInLibrary3[4] += 1;
				}else if(bookId.equals("CS6")) {
					amountOfIssuesForEachBookInLibrary3[5] += 1;
				}else if(bookId.equals("CS7")) {
					amountOfIssuesForEachBookInLibrary3[6] += 1;
				}else if(bookId.equals("CS8")) {
					amountOfIssuesForEachBookInLibrary3[7] += 1;
				}else if(bookId.equals("CS9")) {
					amountOfIssuesForEachBookInLibrary3[8] += 1;
				}else if(bookId.equals("CS10")) {
					amountOfIssuesForEachBookInLibrary3[9] += 1;
				}else if(bookId.equals("CS11")) {
					amountOfIssuesForEachBookInLibrary3[10] += 1;
				}else if(bookId.equals("CS12")) {
					amountOfIssuesForEachBookInLibrary3[11] += 1;
				}else if(bookId.equals("CS13")) {
					amountOfIssuesForEachBookInLibrary3[12] += 1;
				}
			}
		}
		// Find the most issued book in L2
		int lengthL3 = amountOfIssuesForEachBookInLibrary3.length;
		mostIssueL3 = amountOfIssuesForEachBookInLibrary3[0];
		int mostIssueL3Index = 0;
		for(int i=1; i<lengthL3; i++) {
			if(mostIssueL3 < amountOfIssuesForEachBookInLibrary3[i]) {
				mostIssueL3 = amountOfIssuesForEachBookInLibrary3[i];
				mostIssueL3Index = i;
			}
		}
		// We found out which book most issued for each library
		// Finally find the most issued book
		Book mostIssuedBook;
		if(mostIssueL1>mostIssueL2 && mostIssueL1>mostIssueL3) {
			mostIssuedBook = library.getBookArr()[mostIssueL1Index];
		}else if(mostIssueL2>mostIssueL3) {
			mostIssuedBook = library.getBookArr()[20+mostIssueL2Index];
		}else {
			mostIssuedBook = library.getBookArr()[30+mostIssueL3Index];
		}

		System.out.println("1) " + mostIssuedBook.getTitle());

	}
	
	public void memberOfMostIssuedBook() {
		int firstMemberId = members[0].getId();  // Get the ID's for each member
		int secondMemberId = members[1].getId();
		int thirdMemberId = members[2].getId();
		int fourthMemberId = members[3].getId();
		
		int firstMemberIssues = 0;    // Will increment 1 by 1 if there is a issue for the specific member
		int secondMemberIssues = 0;
		int thirdMemberIssues = 0;
		int fourthMemberIssues = 0;
		
		int size = libraryManagement.getIssueObj()[0].length;
		
		for(int i=0; i<libraryManagement.getIssueObj().length; i++) {
			for(int j = 0; j<size; j++) {
				if(libraryManagement.getIssueObj()[i][j] != null) {
					if(firstMemberId == libraryManagement.getIssueObj()[i][j].getMemberId()) {
						firstMemberIssues+=1;
					}else if(secondMemberId == libraryManagement.getIssueObj()[i][j].getMemberId()) {
						secondMemberIssues+=1;
					}else if(thirdMemberId == libraryManagement.getIssueObj()[i][j].getMemberId()) {
						thirdMemberIssues+=1;
					}else if(fourthMemberId == libraryManagement.getIssueObj()[i][j].getMemberId()){
						fourthMemberIssues+=1;
					}
				}
				
			}	
		}
		// Find the member who issues the most books
		String memberIssuedMost = null;
		if(firstMemberIssues>secondMemberIssues && firstMemberIssues>thirdMemberIssues &&
				firstMemberIssues>fourthMemberIssues) {
			memberIssuedMost = members[0].getName();
		}else if(secondMemberIssues>thirdMemberIssues && secondMemberIssues>fourthMemberIssues) {
			memberIssuedMost = members[1].getName();
		}else if(thirdMemberIssues>fourthMemberIssues) {
			memberIssuedMost = members[2].getName();
		}else {
			memberIssuedMost = members[3].getName();
		}
		
		System.out.println("2) " + memberIssuedMost);
		
	}
	// I create this method to return the Months to their equivalent order
	// It returns string. But, the program will parse it later
	public String calculateMonth(String month) {
		String desiredMonth = null;
		switch(month) {
			case "Jan":
				desiredMonth = "01";
				break;
			case "Feb":
				desiredMonth ="02";
				break;
			case "Mar":
				desiredMonth ="03";
				break;
			case "Apr":
				desiredMonth ="04";
				break;
			case "May":
				desiredMonth ="05";
				break;
			case "Jun":
				desiredMonth ="06";
				break;
			case "Jul":
				desiredMonth ="07";
				break;
			case "Aug":
				desiredMonth ="08";
				break;
			case "Sep":
				desiredMonth ="09";
				break;
			case "Oct":
				desiredMonth ="10";
				break;
			case "Nov":
				desiredMonth ="11";
				break;
			case "Dec":
				desiredMonth ="12";
				break;
			default:
				break;
		}
		return desiredMonth;
	}
	
	public void printHighestPenalty() throws ParseException {
		
		int size = libraryManagement.getIssueObj()[0].length;
		double[] penalties = new double[20];
		int count = 0;
		for(int i=0; i<libraryManagement.getIssueObj().length; i++) {
			for(int j = 0; j<size; j++) {
				double penalty = 0;
				if(libraryManagement.getIssueObj()[i][j] != null) {
					String ýssueDate = libraryManagement.getIssueObj()[i][j].getIssueDate();
					String returnDt = libraryManagement.getIssueObj()[i][j].getReturningDate();
					String[] ýssueArr = ýssueDate.split("-");
					String[] returnArr = returnDt.split("-");
					String issueDay = ýssueArr[0];
					String issueMonth = ýssueArr[1];
					String issueYear = "20" + ýssueArr[2];
					String returnDay = returnArr[0];
					String returnMonth = returnArr[1];
					String returnYear = "20" + returnArr[2];
					
					String desiredIssueMonth = calculateMonth(issueMonth);
					String desiredReturnMonth = calculateMonth(returnMonth);
					
					@SuppressWarnings("deprecation")
					Date dateI = new Date(Integer.parseInt(issueYear), Integer.parseInt(desiredIssueMonth)-1, Integer.parseInt(issueDay));
					@SuppressWarnings("deprecation")
					Date ret = new Date(Integer.parseInt(returnYear), Integer.parseInt(desiredReturnMonth)-1, Integer.parseInt(returnDay));
					long date1InMs = dateI.getTime(); 
					long date2InMs = ret.getTime();
					long timeDiff = date2InMs - date1InMs; // Time difference as milliseconds
					if(timeDiff<0){
						timeDiff *= -1; 
					}
					
					int daysDiff = (int) (timeDiff / (1000*60*60*24)); // Convert time difference to days difference
					if(daysDiff>14) {  // After 14 days, 0.50 TL penalty for each day is charged
						penalty = (daysDiff - 14) * (0.5);
						penalties[count] = penalty;
						count++;
					}
					
				}
			}
		}
		//Find highest penalty
		double highestPenalty = 0;
		for(int i=0;i<count; i++) {
			if(penalties[i]>highestPenalty) {
				highestPenalty = penalties[i];
			}
		}
		
		System.out.println("3) " + highestPenalty + " TL");

	}
	
	public void getMostCopiedBook() {
		int numberOfBooks = library.getBookArr().length;
		Book[] books = library.getBookArr();
		int mostCopiedQuantity = 0;
		Book mostCopiedBook = null;
		for(int i=0;i<numberOfBooks; i++) {
			if(books[i] != null && books[i].getQuantity() > mostCopiedQuantity) {
				mostCopiedQuantity = books[i].getQuantity();
				mostCopiedBook = books[i];
			}
		}
		
		System.out.println("4) " + mostCopiedBook.getTitle());
	}
	
	public void fewestCopiedBook() {
		int numberOfBooksInL1 = 20;
		int numberOfBooksInL2 = 10;
		int numberOfBooksInL3 = 13;

		int numberOfL1Issues = libraryManagement.getIssueObj()[0].length;
		int numberOfL2Issues = libraryManagement.getIssueObj()[1].length;
		int numberOfL3Issues = libraryManagement.getIssueObj()[2].length;
		
		int[] amountOfIssuesForEachBookInLibrary1 = new int[numberOfBooksInL1];
		int[] amountOfIssuesForEachBookInLibrary2 = new int[numberOfBooksInL2];
		int[] amountOfIssuesForEachBookInLibrary3 = new int[numberOfBooksInL3];
		// Firstly, set the index in the corresponding array to 0 .. 
		// for each book corresponding libraries
		for(int i = 0; i < numberOfBooksInL1; i++) {
			amountOfIssuesForEachBookInLibrary1[i] = 0;
		}
		for(int i = 0; i < numberOfBooksInL2; i++) {
			amountOfIssuesForEachBookInLibrary2[i] = 0;
		}
		for(int i = 0; i < numberOfBooksInL3; i++) {
			amountOfIssuesForEachBookInLibrary3[i] = 0;
		}
		// Get bookId for each issue in Library1.. 
		// And increase the indexed bookId in the array 1 by 1..
		// According to the bookId order in the L1_Books.csv file	
		for(int j=0; j<numberOfL1Issues;j++) {
			String bookId = getBookId(libraryManagement.getIssueObj()[0][j]);
			if(bookId.equals("R1")) {
				amountOfIssuesForEachBookInLibrary1[0] += 1;
			}else if(bookId.equals("P1")) {
				amountOfIssuesForEachBookInLibrary1[1] += 1;
			}else if(bookId.equals("R2")) {
				amountOfIssuesForEachBookInLibrary1[2] += 1;
			}else if(bookId.equals("R3")) {
				amountOfIssuesForEachBookInLibrary1[3] += 1;
			}else if(bookId.equals("P2")) {
				amountOfIssuesForEachBookInLibrary1[4] += 1;
			}else if(bookId.equals("B1")) {
				amountOfIssuesForEachBookInLibrary1[5] += 1;
			}else if(bookId.equals("B2")) {
				amountOfIssuesForEachBookInLibrary1[6] += 1;
			}else if(bookId.equals("P3")) {
				amountOfIssuesForEachBookInLibrary1[7] += 1;
			}else if(bookId.equals("Fa1")) {
				amountOfIssuesForEachBookInLibrary1[8] += 1;
			}else if(bookId.equals("T1")) {
				amountOfIssuesForEachBookInLibrary1[9] += 1;
			}else if(bookId.equals("Fe1")) {
				amountOfIssuesForEachBookInLibrary1[10] += 1;
			}else if(bookId.equals("R4")) {
				amountOfIssuesForEachBookInLibrary1[11] += 1;
			}else if(bookId.equals("Fe2")) {
				amountOfIssuesForEachBookInLibrary1[12] += 1;
			}else if(bookId.equals("T2")) {
				amountOfIssuesForEachBookInLibrary1[13] += 1;
			}else if(bookId.equals("Fa2")) {
				amountOfIssuesForEachBookInLibrary1[14] += 1;
			}else if(bookId.equals("Fe2")) {
				amountOfIssuesForEachBookInLibrary1[15] += 1;
			}else if(bookId.equals("M1")) {
				amountOfIssuesForEachBookInLibrary1[16] += 1;
			}else if(bookId.equals("Fi1")) {
				amountOfIssuesForEachBookInLibrary1[17] += 1;
			}else if(bookId.equals("H1")) {
				amountOfIssuesForEachBookInLibrary1[18] += 1;
			}else if(bookId.equals("R5")) {
				amountOfIssuesForEachBookInLibrary1[19] += 1;
			}
		}
		// Find the least issued book in L1
		String leastIssuedBookL1 = null;
		int quantity1 = 9999;
		for(int i=0; i<amountOfIssuesForEachBookInLibrary1.length; i++) {
			if(amountOfIssuesForEachBookInLibrary1[i] != 0) {
				if(library.getBookArr()[i].getQuantity() < quantity1) {
					quantity1 = library.getBookArr()[i].getQuantity();
					leastIssuedBookL1 = library.getBookArr()[i].getTitle();
				}
			}
		}
		// Get bookId for each issue in Library2.. 
		// And increase the indexed bookId in the array 1 by 1..
		// According to the bookId order in the L2_Books.csv file	
		for(int j=0; j<numberOfL2Issues;j++) {
			String bookId = getBookId(libraryManagement.getIssueObj()[1][j]);
			if (!bookId.equals("-1")) {
				if(bookId.equals("E1")) {
					amountOfIssuesForEachBookInLibrary2[0] += 1;
				}else if(bookId.equals("E2")) {
					amountOfIssuesForEachBookInLibrary2[1] += 1;
				}else if(bookId.equals("E3")) {
					amountOfIssuesForEachBookInLibrary2[2] += 1;
				}else if(bookId.equals("E4")) {
					amountOfIssuesForEachBookInLibrary2[3] += 1;
				}else if(bookId.equals("E5")) {
					amountOfIssuesForEachBookInLibrary2[4] += 1;
				}else if(bookId.equals("E6")) {
					amountOfIssuesForEachBookInLibrary2[5] += 1;
				}else if(bookId.equals("E7")) {
					amountOfIssuesForEachBookInLibrary2[6] += 1;
				}else if(bookId.equals("E8")) {
					amountOfIssuesForEachBookInLibrary2[7] += 1;
				}else if(bookId.equals("E9")) {
					amountOfIssuesForEachBookInLibrary2[8] += 1;
				}else if(bookId.equals("E10")) {
					amountOfIssuesForEachBookInLibrary2[9] += 1;
				}
			}

		}
		// Find the least issued book in L2
		String leastIssuedBookL2 = null;
		int quantity2 = 9999;
		for(int i=0; i<amountOfIssuesForEachBookInLibrary2.length; i++) {
			if(amountOfIssuesForEachBookInLibrary2[i] != 0) {
				if(library.getBookArr()[20+i].getQuantity() < quantity2) {
					quantity2 = library.getBookArr()[20+i].getQuantity();
					leastIssuedBookL2 = library.getBookArr()[20+i].getTitle();
				}
			}
		}
		// Get bookId for each issue in Library3.. 
		// And increase the indexed bookId in the array 1 by 1..
		// According to the bookId order in the L3_Books.csv file	
		for(int j=0; j<numberOfL3Issues;j++) {
			String bookId = getBookId(libraryManagement.getIssueObj()[2][j]);
			if (!bookId.equals("-1")) {
				if(bookId.equals("CS1")) {
					amountOfIssuesForEachBookInLibrary3[0] += 1;
				}else if(bookId.equals("CS2")) {
					amountOfIssuesForEachBookInLibrary3[1] += 1;
				}else if(bookId.equals("CS3")) {
					amountOfIssuesForEachBookInLibrary3[2] += 1;
				}else if(bookId.equals("CS4")) {
					amountOfIssuesForEachBookInLibrary3[3] += 1;
				}else if(bookId.equals("CS5")) {
					amountOfIssuesForEachBookInLibrary3[4] += 1;
				}else if(bookId.equals("CS6")) {
					amountOfIssuesForEachBookInLibrary3[5] += 1;
				}else if(bookId.equals("CS7")) {
					amountOfIssuesForEachBookInLibrary3[6] += 1;
				}else if(bookId.equals("CS8")) {
					amountOfIssuesForEachBookInLibrary3[7] += 1;
				}else if(bookId.equals("CS9")) {
					amountOfIssuesForEachBookInLibrary3[8] += 1;
				}else if(bookId.equals("CS10")) {
					amountOfIssuesForEachBookInLibrary3[9] += 1;
				}else if(bookId.equals("CS11")) {
					amountOfIssuesForEachBookInLibrary3[10] += 1;
				}else if(bookId.equals("CS12")) {
					amountOfIssuesForEachBookInLibrary3[11] += 1;
				}else if(bookId.equals("CS13")) {
					amountOfIssuesForEachBookInLibrary3[12] += 1;
				}
			}

		}
		// Find the least issued book in L3
		String leastIssuedBookL3 = null;
		int quantity3 = 9999;
		for(int i=0; i<amountOfIssuesForEachBookInLibrary2.length; i++) {
			if(amountOfIssuesForEachBookInLibrary3[i] != 0) {
				if(library.getBookArr()[30+i].getQuantity() < quantity3) {
					quantity3 = library.getBookArr()[30+i].getQuantity();
					leastIssuedBookL3 = library.getBookArr()[30+i].getTitle();
				}
			}
		}
		
		System.out.println("5) The book with the fewest copies of previously issued books:");
		System.out.println("      For L1: " + leastIssuedBookL1 + " (" + quantity1 + " copies)");
		System.out.println("      For L2: " + leastIssuedBookL2 + " (" + quantity2 + " copies)");
		System.out.println("      For L3: " + leastIssuedBookL3 + " (" + quantity3 + " copies)");
	}
	
	
	// Actually this method same with memberOfMostIssuedBook()
	// Slightly different
	// This method finds the member who issues the least number of books from the Computer Science Library
	public void memberOfLeastIssuedBookInCSLibrary() {
		int firstMemberId = members[0].getId();
		int secondMemberId = members[1].getId();
		int thirdMemberId = members[2].getId();
		int fourthMemberId = members[3].getId();
		
		int firstMemberIssues = 0;
		int secondMemberIssues = 0;
		int thirdMemberIssues = 0;
		int fourthMemberIssues = 0;
		
		int size = libraryManagement.getIssueObj()[2].length;
		
		for(int i=0; i<size; i++) {
			if(libraryManagement.getIssueObj()[2][i] != null) {
				if(firstMemberId == libraryManagement.getIssueObj()[2][i].getMemberId()) {
					firstMemberIssues+=1;
				}else if(secondMemberId == libraryManagement.getIssueObj()[2][i].getMemberId()) {
					secondMemberIssues+=1;
				}else if(thirdMemberId == libraryManagement.getIssueObj()[2][i].getMemberId()) {
					thirdMemberIssues+=1;
				}else if(fourthMemberId == libraryManagement.getIssueObj()[2][i].getMemberId()){
					fourthMemberIssues+=1;
				}
			}
		}
		
		String memberIssuedLeast = null;
		if(firstMemberIssues<secondMemberIssues && firstMemberIssues<thirdMemberIssues &&
				firstMemberIssues<fourthMemberIssues) {
			memberIssuedLeast = members[0].getName();
		}else if(secondMemberIssues<thirdMemberIssues && secondMemberIssues<fourthMemberIssues) {
			memberIssuedLeast = members[1].getName();
		}else if(thirdMemberIssues<fourthMemberIssues) {
			memberIssuedLeast = members[2].getName();
		}else {
			memberIssuedLeast = members[3].getName();
		}
		
		System.out.println("6) " + memberIssuedLeast);

	}

}
