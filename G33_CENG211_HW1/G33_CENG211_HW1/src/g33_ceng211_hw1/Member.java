package g33_ceng211_hw1;

public class Member {
	
	private int id;
	private String name;
	private String mail;
	
	public Member (int id, String name, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}

	public String toString() {
		return "Member: " + "ID= " + id  +", name=" + name + ", Email= " + mail;
	}
	
}
