package g33_ceng211_hw2;

public class Document extends Applicant {
	
	private String documentType;
	private int duration;
	
	public Document(int applicantID, String documentType, int duration) {
		super(applicantID);
		this.documentType = documentType;
		this.duration = duration;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
