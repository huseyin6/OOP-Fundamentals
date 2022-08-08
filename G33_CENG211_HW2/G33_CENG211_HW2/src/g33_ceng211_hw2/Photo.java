package g33_ceng211_hw2;

public class Photo extends Applicant {
	
	private String resolution;
	private String position;
	
	public Photo(int applicantID, String resolution, String position) {
		super(applicantID);
		this.position = position;
		this.resolution = resolution;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
