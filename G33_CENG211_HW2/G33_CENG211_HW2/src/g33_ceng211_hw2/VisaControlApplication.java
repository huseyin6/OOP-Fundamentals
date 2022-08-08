package g33_ceng211_hw2;

import java.util.ArrayList;


public class VisaControlApplication {
	private static FileIO fileIO = new FileIO();

	public static void main(String[] args) {
		fileIO.readFile();
		
		ArrayList<Integer> applicants = fileIO.getApplicantList();
		ArrayList<ApplicantInfo> applicantInfos = fileIO.getApplicantInfoList();
		ArrayList<Passport> passports = fileIO.getPassportList();
		ArrayList<Photo> photos = fileIO.getPhotoList();
		ArrayList<FinancialStatus> financialStatus = fileIO.getFinancialStatueList();
		ArrayList<Document> documents = fileIO.getDocumentList();
		
		AcceptanceRules acceptanceRules = new AcceptanceRules(applicantInfos, passports, photos, financialStatus, documents);
		
		int applicantInfosLength = applicantInfos.size();
		int applicantNumber = applicants.size();
		for(int k=0; k<applicantNumber; k++) {
			for(int i=0; i<applicantInfosLength; i++) {
				if (applicants.get(k) == applicantInfos.get(i).getApplicantID()) {
					ApplicantInfo applicant = applicantInfos.get(i);
					if (!acceptanceRules.checkHavePassport(applicant)) {
						acceptanceRules.printRejected(applicant, "Applicant does not have a passport");
					}else if(!acceptanceRules.checkPassportValidity(applicant)) {
						acceptanceRules.printRejected(applicant, "Passport is not valid");
					}else if(!acceptanceRules.checkExpDate(applicant)) {
						acceptanceRules.printRejected(applicant, "Passport expiration date is not valid");
					}else if(!acceptanceRules.checkHavePhoto(applicant)) {
						acceptanceRules.printRejected(applicant, "Applicant does not have a photo");
					}else if(!acceptanceRules.checkResolution(applicant)) {
						acceptanceRules.printRejected(applicant, "Resolution of photo is not valid");
					}else if(!acceptanceRules.checkPosition(applicant)) {
						acceptanceRules.printRejected(applicant, "Position in the photo is not valid");
					}else if(!acceptanceRules.checkFinancialStatusReport(applicant)) {
						acceptanceRules.printRejected(applicant, "Applicant does not have a financial status report");
					}else if(!acceptanceRules.checkStability(applicant)) {
						acceptanceRules.printRejected(applicant, "Applicant does not have a stable financial status");
					}else {
						int duration = acceptanceRules.visaDuration(applicant);
						acceptanceRules.printAccepted(applicant, duration);
					}
					
				}
			}
		}

 	}

}
