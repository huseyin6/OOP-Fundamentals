package g33_ceng211_hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileIO {
	
	ApplicantInfo applicantInfo = new ApplicantInfo(0, null);
	Passport passport = new Passport(0, null, null);
	Photo photo = new Photo(0, null, null);
	FinancialStatus financialStatue = new FinancialStatus(0, 0, 0);
	Document document = new Document(0, null, 0);
	
	ArrayList<Integer> applicants = new ArrayList<Integer>();
	ArrayList<ApplicantInfo> applicantInfoList = new ArrayList<ApplicantInfo>();
	ArrayList<Passport> passportList = new ArrayList<Passport>();
	ArrayList<Photo> photoList = new ArrayList<Photo>();
	ArrayList<FinancialStatus> financialStatueList = new ArrayList<FinancialStatus>();
	ArrayList<Document> documentList = new ArrayList<Document>();
	
	public void readFile() {	
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/HW2_ApplicantsInfo.csv"));
			String line = reader.readLine();
			
			while (line != null) {
				String[] Arr = line.split(",");
				int applicantId = Integer.parseInt(Arr[1]);
				if(Arr[0].equals("A")) {
					applicants.add(applicantId);
					String applicantName = Arr[2];
					addToList(new ApplicantInfo(applicantId, applicantName));
				}else if(Arr[0].equals("S")) {
					String passportNumber = Arr[2];
					String expDate = Arr[3];
					addToList(new Passport(applicantId, passportNumber, expDate));
				}else if(Arr[0].equals("P")) {
					String resolution = Arr[2];
					String position = Arr[3];
					addToList(new Photo(applicantId, resolution, position));
				}else if(Arr[0].equals("F")) {
					int income = Integer.parseInt(Arr[2]);
					int savings = Integer.parseInt(Arr[3]);
					addToList(new FinancialStatus(applicantId, income, savings));
				}else {
					String documentType = Arr[2];
					if (Arr.length == 4) {
						int duration = Integer.parseInt(Arr[3]);
						addToList(new Document(applicantId, documentType, duration));
					}else {
						addToList(new Document(applicantId, documentType, 0));
					}
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addToList(Applicant applicant) {
		if(applicant.getClass() == applicantInfo.getClass()) {
			applicantInfoList.add((ApplicantInfo) applicant);
		}else if(applicant.getClass() == passport.getClass()) {
			passportList.add((Passport) applicant);
		}else if(applicant.getClass() == photo.getClass()) {
			photoList.add((Photo) applicant);
		}else if(applicant.getClass() == financialStatue.getClass()) {
			financialStatueList.add((FinancialStatus) applicant);
		}else {
			documentList.add((Document) applicant);
		}
	}

	public ArrayList<Integer> getApplicantList() {
		Collections.sort(applicants);
		return applicants;
	}
	
	
	public ArrayList<ApplicantInfo> getApplicantInfoList() {
		return applicantInfoList;
	}

	public void setApplicantInfoList(ArrayList<ApplicantInfo> applicantInfoList) {
		this.applicantInfoList = applicantInfoList;
	}

	public ArrayList<Passport> getPassportList() {
		return passportList;
	}

	public void setPassportList(ArrayList<Passport> passportList) {
		this.passportList = passportList;
	}

	public ArrayList<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(ArrayList<Photo> photoList) {
		this.photoList = photoList;
	}

	public ArrayList<FinancialStatus> getFinancialStatueList() {
		return financialStatueList;
	}

	public void setFinancialStatueList(ArrayList<FinancialStatus> financialStatueList) {
		this.financialStatueList = financialStatueList;
	}

	public ArrayList<Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(ArrayList<Document> documentList) {
		this.documentList = documentList;
	}

	public Passport getPassport() {
		return passport;
	}

	public Photo getPhoto() {
		return photo;
	}

}