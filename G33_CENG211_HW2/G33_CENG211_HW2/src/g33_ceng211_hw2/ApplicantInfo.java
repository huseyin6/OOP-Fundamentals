package g33_ceng211_hw2;

public class ApplicantInfo extends Applicant {
	
	private String applicantName;
	
	public ApplicantInfo(int applicantID, String applicantName) {
		super(applicantID);
		this.applicantName = applicantName;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	
}
