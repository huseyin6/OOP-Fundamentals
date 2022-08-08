package g33_ceng211_hw1;

public class Book {
	
	private String id;
	private String title;
	private String author;
	private String publisher;
	private int edition;
	private String genre;
	private int quantity;
	
	public Book(String id, String title, String author, String publisher, int edition, String genre, int quantity) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.genre = genre;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return "Book: " + "Title= " + title  +", Author= " + author + ", Publisher= " + publisher
				+ ", Edition= " + edition +", Genre= " + genre + ", Quantity= " + quantity;
	}
	

}
