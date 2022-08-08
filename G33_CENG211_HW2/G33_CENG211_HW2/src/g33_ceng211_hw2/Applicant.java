package g33_ceng211_hw2;

public class Applicant {
	
	private int applicantID;

	public Applicant(int applicantID) {
		super();
		this.applicantID = applicantID;
	}
	
	public int getApplicantID() {
		return applicantID;
	}

	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}
	
	public String visaType() {
		String convertedId = String.valueOf(this.applicantID);
		String prefix = convertedId.substring(0, 2);
		String type = typeOfApplication(prefix);
		return type;
	}
	
	private String typeOfApplication(String prefix) {
		String desiredType = null;
		switch(prefix) {
			case "11":
				desiredType = "Tourist";
				break;

			case "23":
				desiredType = "Worker";
				break;
				
			case "25":
				desiredType = "Educational";
				break;
			
			case "30":
				desiredType = "Immigrant";
				break;
				
			default:
				break;
		}
		return desiredType;
	}

}
