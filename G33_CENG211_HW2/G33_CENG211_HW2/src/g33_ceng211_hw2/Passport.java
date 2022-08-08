package g33_ceng211_hw2;

public class Passport extends Applicant {
	
	private String passportNumber;
	private String passportexpDate;
	
	public Passport(int applicantID, String passportNumber, String expDate) {
		super(applicantID);
		this.passportNumber = passportNumber;
		this.passportexpDate =  expDate;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportexpDate() {
		return passportexpDate;
	}

	public void setPassportexpDate(String passportexpDate) {
		this.passportexpDate = passportexpDate;
	}
	
}
