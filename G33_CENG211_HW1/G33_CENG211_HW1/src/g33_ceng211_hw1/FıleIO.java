package g33_ceng211_hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FıleIO {
	
	// Read Books and add them to Library (One-Dimesional)
	public Library readBooks() {
		
		Library library = new Library();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("src/L1_Books.csv"));
			String line = reader.readLine();
			
			while (line != null) {
				
				String[] Arr = line.split(",");
				
				String id = Arr[0];
				String title = Arr[1];
				String author = Arr[2];
				String publisher = Arr[3];
				int edition = Integer.parseInt(Arr[4]);
				String genre = Arr[5];
				int quantity = Integer.parseInt(Arr[6]);
				Book newBook = new Book(id,title,author,publisher,edition,genre,quantity);
				
				library.add(newBook);
				
				line = reader.readLine();
			}
			
			reader.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("src/L2_Books.csv"));
			String line = reader.readLine();
			
			while (line != null) {
				
				String[] Arr = line.split(",");
				
				String id = Arr[0];
				String title = Arr[1];
				String author = Arr[2];
				String publisher = Arr[3];
				int edition = Integer.parseInt(Arr[4]);
				String genre = Arr[5];
				int quantity = Integer.parseInt(Arr[6]);
				Book newBook = new Book(id,title,author,publisher,edition,genre,quantity);
				
				library.add(newBook);
				
				line = reader.readLine();
			}
			
			reader.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("src/L3_Books.csv"));
			String line = reader.readLine();
			
			while (line != null) {
				
				String[] Arr = line.split(",");
				
				String id = Arr[0];
				String title = Arr[1];
				String author = Arr[2];
				String publisher = Arr[3];
				int edition = Integer.parseInt(Arr[4]);
				String genre = Arr[5];
				int quantity = Integer.parseInt(Arr[6]);
				Book newBook = new Book(id,title,author,publisher,edition,genre,quantity);
				
				library.add(newBook);
				
				line = reader.readLine();
			}
			
			reader.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return library;
	}
	
	// Read Issues and add them to LibraryManagement system (Two-Dimesional)
	public LibraryManagement readIssues() {
		
		LibraryManagement libraryManagement = new LibraryManagement(3,30); // 3 Libraries and 30 issues for each
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("src/L1_Issues.csv"));
			String line = reader.readLine();
			
			while (line != null) {
				String[] Arr = line.split(",");
				
				int id = Integer.parseInt(Arr[0]);
				int memberId = Integer.parseInt(Arr[1]);
				String bookId = Arr[2];
				String issueDate = Arr[3];
				String returningDate = Arr[4];

				Issue newIssue = new Issue(id, memberId, bookId, issueDate, returningDate);
				libraryManagement.add(newIssue, 0);  // 0 depicts the L1
				line = reader.readLine();

			}
			reader.close();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
		libraryManagement.setNumberOfObjects(0); // set the number of objects 0 because the program must have start 
												// from the L2 with index 0
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("src/L2_Issues.csv"));
			String line = reader.readLine();
			
			while (!line.equals(",,,,")) {
					
				String[] Arr = line.split(",");
				
				int id = Integer.parseInt(Arr[0]);
				int memberId = Integer.parseInt(Arr[1]);
				String bookId = Arr[2];
				String issueDate = Arr[3];
				String returningDate = Arr[4];

				Issue newIssue = new Issue(id, memberId, bookId, issueDate, returningDate);
				libraryManagement.add(newIssue, 1); // 1 depicts the L2
				line = reader.readLine();
				
			}
			reader.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}			
		libraryManagement.setNumberOfObjects(0); // set the number of objects 0 because the program must have start 
												// from the L3 with index 0
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/L3_Issues.csv"));
			String line = reader.readLine();

			while (line != null) {
				
				String[] Arr = line.split(",");
				
				int id = Integer.parseInt(Arr[0]);
				int memberId = Integer.parseInt(Arr[1]);
				String bookId = Arr[2];
				String issueDate = Arr[3];
				String returningDate = Arr[4];

				Issue newIssue = new Issue(id, memberId, bookId, issueDate, returningDate);

				libraryManagement.add(newIssue, 2); // 1 depicts the L3
				line = reader.readLine();
			}
			
			reader.close();
		
		}catch (IOException e) {
			e.printStackTrace();
		}

		return libraryManagement;
	}
	
	// Read Members, add them to an Array (One-Dimesional) and return the Array object
	public Member[] readMembers() {
		Member[] members = new Member[4];
		int count = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/Members.csv"));
			String line = reader.readLine();
			line = reader.readLine();
			line = reader.readLine();
			while (line != null) {
				String[] Arr = line.split(",");
				
				int id = Integer.parseInt(Arr[0]);
				String name = Arr[1];
				String mail = Arr[2];

				Member newMember = new Member(id, name, mail);
				members[count] = newMember;
				line = reader.readLine();
				count++;
			}
			reader.close();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return members;

	}
	
}
