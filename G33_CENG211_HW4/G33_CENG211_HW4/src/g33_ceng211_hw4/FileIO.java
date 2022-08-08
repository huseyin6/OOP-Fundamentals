package g33_ceng211_hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class FileIO {
	
	ArrayList<Commercial> commercials = new ArrayList<Commercial>();
	ArrayList<Individual<String>> memberIndividuals = new ArrayList<Individual<String>>();
	ArrayList<Individual<Long>> nonMemberIndividuals = new ArrayList<Individual<Long>>();
	
	public void readRentals() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/HW4_Rentals.csv"));
			String line = reader.readLine();

			while ((line != null)) {
				String[] Arr = line.split(",");
				if (Arr.length != 6 ) {
					break;
				}
				if (Arr[0].equals("Individual")) {
					String id = Arr[1];
					//individualCheckID() method checks id whether is valid or not.
					//It does this by try-catch mechanism (Exception Handling!!!)
					if (isNumeric(id) && individualCheckID(id)) {
						long individualId = Long.parseLong(id);
						int numberOfDays = Integer.parseInt(Arr[2]);
						String carModel = Arr[3];
						int modelYear = Integer.parseInt(Arr[4]);
						double basePrice = Double.parseDouble(Arr[5]);
						long rentalCode = generateRentalCode();
						Individual<Long> nonMemberIndividual = new Individual<Long>(individualId, numberOfDays, carModel, modelYear, basePrice);
						nonMemberIndividual.setRentalCode(rentalCode);
						nonMemberIndividuals.add(nonMemberIndividual);
					}
					else {
						int numberOfDays = Integer.parseInt(Arr[2]);
						String carModel = Arr[3];
						int modelYear = Integer.parseInt(Arr[4]);
						double basePrice = Double.parseDouble(Arr[5]);
						long rentalCode = generateRentalCode();		
						Individual<String> memberIndividual = new Individual<String>(id, numberOfDays, carModel, modelYear, basePrice);
						memberIndividual.setRentalCode(rentalCode);
						memberIndividuals.add(memberIndividual);
					}
				
				}else {
					String id = Arr[1];
					//If customer ID format is not appropriate for customer types, necessary exceptions
					//should be thrown. 
					//commercialCheckID() method satisfies these conditions. (Exception Handling!!!)
					boolean isValid = commercialCheckID(id);
					if (isValid) {
						int numberOfMonths = Integer.parseInt(Arr[2]);
						String carModel = Arr[3];
						int modelYear = Integer.parseInt(Arr[4]);
						double basePrice = Double.parseDouble(Arr[5]);
						long rentalCode = generateRentalCode();
						Commercial newComm = new Commercial(id, numberOfMonths, carModel, modelYear, basePrice);
						newComm.setRentalCode(rentalCode);
						commercials.add(newComm);
					}
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	private boolean individualCheckID(String id) {
		if (id.startsWith("M")) {
			try  
			  {
				if (id.length() == 12) {
					Long ID = Long.parseLong(id.substring(1, 12));
					return true;
				}
			  }  
			  catch(NumberFormatException nfe)  
			  {  
			    System.out.println("Incorrect");
			  }  
			
			return false;
		}else {
			try  
			  {
				if (id.length() == 11) {
					Long ID = Long.parseLong(id);
					return true;
				}
			  }  
			  catch(NumberFormatException nfe)  
			  {  
			    System.out.println("Incorrect");
			  }  
			
			return false;
		}
		
	}
	
	private boolean commercialCheckID(String id) {
		if (id.startsWith("S") || id.startsWith("G") || id.startsWith("P")) {
			try  
			  {
				if (id.length() == 8) {
					Long ID = Long.parseLong(id.substring(1, 8));
					return true;
				}
			  }  
			  catch(NumberFormatException nfe)  
			  {  
			    System.out.println("Incorrect");
			  }  
			return false;
		}
		return false;	
	}
	
	private boolean isNumeric(String strNum) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
	public long generateRentalCode() {
		Random rand = new Random(); 
		int code = rand.nextInt(9000000) + 1000000;
		return code;
	}

	public ArrayList<Commercial> getCommercials() {
		return commercials;
	}

	public void setCommercials(ArrayList<Commercial> commercials) {
		this.commercials = commercials;
	}

	public ArrayList<Individual<String>> getMemberIndividuals() {
		return memberIndividuals;
	}

	public void setMemberIndividuals(ArrayList<Individual<String>> memberIndividuals) {
		this.memberIndividuals = memberIndividuals;
	}

	public ArrayList<Individual<Long>> getNonMemberIndividuals() {
		return nonMemberIndividuals;
	}

	public void setNonMemberIndividuals(ArrayList<Individual<Long>> nonMemberIndividuals) {
		this.nonMemberIndividuals = nonMemberIndividuals;
	}

}
