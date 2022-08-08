package g33_ceng211_hw2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

public class AcceptanceRules {
	
	private ArrayList<Passport> s;
	private ArrayList<Photo> p;
	private ArrayList<FinancialStatus> f;
	private ArrayList<Document> d;
	
	public AcceptanceRules(ArrayList<ApplicantInfo> a, ArrayList<Passport> s, ArrayList<Photo> p,
			ArrayList<FinancialStatus> f, ArrayList<Document> d) {
		this.s = s;
		this.p = p;
		this.f = f;
		this.d = d;
	}
	
	public void printRejected(ApplicantInfo info, String reason) {
		System.out.println("Applicant ID: " + info.getApplicantID() + ", Name: " + info.getApplicantName() + 
				", Visa Type: " + info.visaType() + ", Status: Rejected" + ", Reason: " + reason);
	}
	
	public void printAccepted(ApplicantInfo info, int duration) {
		String strDuration = "";
		if (duration == 6) {
			strDuration = "6 months";
		}else if(duration == 12) {
			strDuration = "1 years";
		}else if(duration == 24) {
			strDuration = "2 years";
		}else if(duration == 48) {
			strDuration = "4 years";
		}else if(duration == 60) {
			strDuration = "5 years";
		}else if(duration == -1) {
			strDuration = "Permanent";
		}else {
			
		}
		System.out.println("Applicant ID: " + info.getApplicantID() + ", Name: " + info.getApplicantName() + 
				", Visa Type: " + info.visaType() + ", Status: Accepted" + ", Visa Duration: " + strDuration);
	}
	
	public boolean isNumeric(String strNum) {
		return strNum.matches("-?\\d+(\\.\\d+)?");
	}
	
	public boolean checkHavePassport(ApplicantInfo info) {
		boolean isFound = false;
		for(int j=0; j<this.s.size(); j++) {
			if (info.getApplicantID() == this.s.get(j).getApplicantID()) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}

	public boolean checkPassportValidity(ApplicantInfo info) {
		boolean isValid = false;
		for(int j=0; j<this.s.size(); j++) {
			if (info.getApplicantID() == this.s.get(j).getApplicantID()) {
				if(this.s.get(j).getPassportNumber().length() == 10) {
					String pNumber = this.s.get(j).getPassportNumber();
					if((pNumber.substring(0, 1).equals("P")) && (isNumeric(pNumber.substring(7, 10)))) {
						isValid = true;
						break;
					}
				}
				break;
			}
		}
		return isValid;
	}
	
	public boolean checkExpDate(ApplicantInfo info) {
		boolean isValid = false;
		for(int j=0; j<this.s.size(); j++) {
			if (info.getApplicantID() == this.s.get(j).getApplicantID()) {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String today = format.format(calendar.getTime());
				long diff = ChronoUnit.MONTHS.between(LocalDate.parse(today), LocalDate.parse(this.s.get(j).getPassportexpDate()));
				if(diff >= 6) {
					isValid = true;
				}
			}
		}
		return isValid;
	}
		
	
	public boolean checkHavePhoto(ApplicantInfo info) {
		boolean isFound = false;
		for(int j=0; j<this.p.size(); j++) {
			if (info.getApplicantID() == this.p.get(j).getApplicantID()) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}
	
	public boolean checkResolution(ApplicantInfo info) {
		boolean isSquare = true;
		for(int j=0; j<this.p.size(); j++) {
			if (info.getApplicantID() == this.p.get(j).getApplicantID()) {
				String[] arr = this.p.get(j).getResolution().split("x");
				if(!arr[0].equals(arr[1])) {
					isSquare = false;
					break;
				}
			}
		}
		return isSquare;
	}
	
	public boolean checkPosition(ApplicantInfo info) {
		boolean isOkey = false;
		for(int j=0; j<this.p.size(); j++) {
			if (info.getApplicantID() == this.p.get(j).getApplicantID()) {
				if(this.p.get(j).getPosition().equals("Natural Smile") || this.p.get(j).getPosition().equals("Neutral Face")) {
					isOkey = true;
					break;
				}
			}
		}
		return isOkey;
	}
	
	public boolean checkFinancialStatusReport(ApplicantInfo info) {
		boolean isFound = false;
		for(int j=0; j<this.f.size(); j++) {
			if (info.getApplicantID() == this.f.get(j).getApplicantID()) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}
	
	public boolean checkStability(ApplicantInfo info) {
		boolean stability = false;
		for(int j=0; j<this.f.size(); j++) {
			if (info.getApplicantID() == this.f.get(j).getApplicantID()) {
				FinancialStatus status = this.f.get(j);
				String type = this.f.get(j).visaType();
				if(type.equals("Tourist")) {
					for(int i=0; i<this.d.size(); i++) {
						if(status.getApplicantID() == this.d.get(i).getApplicantID()) {
							Document doc = this.d.get(i);
							if(doc.getDocumentType().equals("IL")) {
								if(status.getIncome() >= 1000) {
									if(status.getIncome() <= 1500 && status.getSavings() >= 6000) {
										stability = true;
									}else if(1500 <= status.getIncome() && status.getIncome() <= 2000 && status.getSavings() >= 3000) {
										stability = true;
									}else if (status.getIncome() >= 2000){
										stability = true;
									}
								}
							}
							if(status.getIncome() >= 2000) {
								if(status.getIncome() <= 3000 && status.getSavings() >= 12000) {
									stability = true;
								}else if(3000 <= status.getIncome() && status.getIncome() <= 4000 && status.getSavings() >= 6000) {
									stability = true;
								}else if (status.getIncome() >= 4000){
									stability = true;
								}
							}
						}
					}

				}else if(type.equals("Worker")) {
					if(status.getSavings() >= 2000) {
						stability = true;
					}
				}else if(type.equals("Educational")) {
					if(status.getIncome() >= 1000) {
						if(status.getIncome() <= 2000 && status.getSavings() >= 6000) {
							stability = true;
						}else if(2000 <= status.getIncome() && status.getIncome() <= 3000 && status.getSavings() >= 3000) {
							stability = true;
						}else if (status.getIncome() >= 3000){
							stability = true;
						}
					}
				}else {
					String[] docs = new String[2];
					for(int i=0; i<this.d.size(); i++) {
						if(this.d.get(i).getApplicantID() == status.getApplicantID()) {
							if(docs[0] == null ) {
								docs[0] = this.d.get(i).getDocumentType();
							}else {
								docs[1] = this.d.get(i).getDocumentType();
							}
						}
					}
					if (docs[0] != null) {
						if(docs[0].equals("GC")) {
							if (docs[1] != null) {
								if(docs[0].equals("IL")) {
									if (status.getSavings() >= 2000)
										stability = true;
								}
							}else {
								if (status.getSavings() >= 4000)
									stability = true;
							}

					}else {
						if (status.getSavings() >= 50000)
							stability = true;
					}
				}
			}
			}
		}
		return stability;
	}
	
	public boolean checkDocument(ApplicantInfo info) {
		boolean hasLA = false;
		for(int j=0; j<this.d.size(); j++) {
			if (info.getApplicantID() == this.d.get(j).getApplicantID()) {
				String type = this.d.get(j).visaType();
				if(type.equals("Worker")) {
						if(this.d.get(j).getDocumentType().equals("LA")) {
							hasLA = true;
						}
				}else if(type.equals("Educational")) {
					if(this.d.get(j).getDocumentType().equals("LA")) {
						hasLA = true;
					}		
				}else {
					hasLA = true;
				}
			}
		}	
		return hasLA;
	}
	
	
	public long expiration(ApplicantInfo info) {
		long diff = -1;
		for(int j=0; j<this.s.size(); j++) {
			if (info.getApplicantID() == this.s.get(j).getApplicantID()) {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String today = format.format(calendar.getTime());
				diff = ChronoUnit.MONTHS.between(LocalDate.parse(today), LocalDate.parse(this.s.get(j).getPassportexpDate()));
			}
		}
		return diff;
	}
	
	
	public int visaDuration(ApplicantInfo info) {		
		double durationConstant;
		int calculatedDuration = 0;
		for (int j=0; j<this.d.size(); j++) {
			if (info.getApplicantID() == this.d.get(j).getApplicantID()) {
				Document doc = this.d.get(j);
				String type = this.d.get(j).visaType();
				long expirationDate = this.expiration(info);
				for(int i = 0; i<this.f.size(); i++) {
					if(doc.getApplicantID() == this.f.get(i).getApplicantID()) {
						int income = this.f.get(i).getIncome();
						int savings = this.f.get(i).getSavings();
						
						if(type.equals("Immigrant")) {
							return -1;
						}	
						
						else if(type.equals("Tourist")) {
	
							if(doc.getDocumentType().equals("IL")){
								durationConstant = ((income - 2000)*6 + savings) / 6000;
							}else {
								durationConstant = ((income - 2000)*6 + savings) / 12000;
							}
						
						
							if (durationConstant >= 1 && durationConstant < 2) {
								calculatedDuration = 6;
							}else if (durationConstant >= 2 && durationConstant < 4) {
								calculatedDuration = 12;
							}else if (durationConstant >= 4) {
								calculatedDuration = 60;
							}
							
							
							if (calculatedDuration <= expirationDate) {
								return calculatedDuration;
							}else {
								if (calculatedDuration == 6)
									return 0;
								else if (calculatedDuration == 12)
									return 6;
								else if(calculatedDuration == 60)
									return 12;
							}
						}				
					
						else if(type.equals("Worker")) {
							if(doc.getDocumentType().equals("LA")){
								int acceptanceDuration = doc.getDuration();
								if (acceptanceDuration != 0) {
									if (acceptanceDuration > expirationDate) {
										if (expirationDate < 60)
											return 24;
										else if (expirationDate < 24)
											return 12;
										else if (expirationDate < 12)
											return 0;
									}else {
										if (expirationDate > 12) {
											if (expirationDate < 24)
												return 12;
											else if (expirationDate < 60)
												return 24;
											else 
												return 60;
										}else {
											return 0;
										}
									}
									
								}else {
									return -2;
								}
							}
						}
					
						else if(type.equals("Educational")) {
							if(doc.getDocumentType().equals("LA")){
								int duration = doc.getDuration();
								if (duration != 0) {
									if (duration > expirationDate) {
										if (expirationDate < 48)
											return 24;
										else if (expirationDate < 24)
											return 12;
										else if (expirationDate < 12)
											return 0;
									}else {
										if (expirationDate > 12) {
											if (expirationDate < 24)
												return 12;
											else if (expirationDate < 48)
												return 24;
											else 
												return 48;
										}
										else
											return 0;
									}
								}
							}
						}
					}
				}
			}
		}
		return -3;
	}
	
	
}
