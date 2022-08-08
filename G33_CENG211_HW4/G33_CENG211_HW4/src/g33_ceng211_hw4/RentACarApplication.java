package g33_ceng211_hw4;

import java.util.ArrayList;

public class RentACarApplication {
	
	private static FileIO fileIO = new FileIO();
	
	public static void main(String[] args) {
		
		fileIO.readRentals();
		ArrayList<Commercial> commercials = fileIO.getCommercials();
		ArrayList<Individual<String>> memberIndividuals = fileIO.getMemberIndividuals();
		ArrayList<Individual<Long>> nonMemberIndividuals = fileIO.getNonMemberIndividuals();
		
		int numberOfIndividuals = memberIndividuals.size() + nonMemberIndividuals.size();
		int numberOfCommercials = commercials.size();
		int totalCarsRented = numberOfCommercials + numberOfIndividuals;
		
		//Outputs
		System.out.println("Welcome!");
		System.out.println("Total number of cars rented: " + totalCarsRented);
		System.out.println("Total number of commercial rentals: " + numberOfCommercials);
		
		int totalMonths = 0;
		for (Commercial comm: commercials) {
			totalMonths += comm.getNumberOfMonths();
		}
		System.out.println("Total number of commercial rental-month: " + totalMonths);
		
		System.out.println("Total number of individual rentals: " + numberOfIndividuals);
		
		int totalDays = 0;
		for (Individual<String> ind: memberIndividuals) {
			totalDays += ind.getNumberOfDays();
		}
		for (Individual<Long> ind: nonMemberIndividuals) {
			totalDays += ind.getNumberOfDays();
		}
		System.out.println("Total number of individual rental-day: " + totalDays);
		
		System.out.println("Total number of rentals of individual non-member customers: " + nonMemberIndividuals.size());
		System.out.println("Total number of rentals of individual member customers: " + memberIndividuals.size());
		
		int countSilvers = 0;
		int countGolds = 0;
		int countPlats = 0;
		
		for (Commercial c: commercials) {
			String type = c.getCustomerType();
			if(type.equals("Silver")) {
				countSilvers++;
			}else if(type.equals("Gold")) {
				countGolds++;
			}else {
				countPlats++;
			}
		}
		System.out.println("Total number of rentals of silver commercial customers: " + countSilvers);
		System.out.println("Total number of rentals of gold commercial customers: " + countGolds);
		System.out.println("Total number of rentals of platinum commercial customers: " + countPlats);
		System.out.println();
		
		//Individual Rentals
		System.out.println("Individual Rentals:");
		System.out.println("No  Rental Code   Customer ID    isMember   Number of Days   Car Model        Model Year   Rental Price");
		int count = 1;
		for(int i=0; i<3; i++) {
			Individual<Long> nonMember = nonMemberIndividuals.get(i);
			Individual<String> member = memberIndividuals.get(i);
			System.out.print(count +  "     " + nonMember.getRentalCode() + "     " + nonMember.getId() + "     " +  nonMember.isMember() + "          " +
			nonMember.getNumberOfDays() + "           " + nonMember.getCarModel());
			if (nonMember.getCarModel().length() > 12) {
				System.out.print("   " +  nonMember.getModelYear() + "         " + nonMember.calculateRentalPrice());
			}else {
				System.out.print("       " + nonMember.getModelYear() + "         " + nonMember.calculateRentalPrice());
			}
			System.out.println();
			count++;
			System.out.print(count +  "     " + member.getRentalCode() + "     " + member.getId() + "     " +  member.isMember() + "          " +
					member.getNumberOfDays() + "           " + member.getCarModel());
			if (member.getCarModel().length() > 12) {
				System.out.print("   " +  member.getModelYear() + "         " + member.calculateRentalPrice());
			}else {
				System.out.print("        " + member.getModelYear() + "         " + member.calculateRentalPrice());
			}
			System.out.println();
			count++;
		}
		count = 1;
		System.out.println();
		
		//Commercial Rentals
		System.out.println("Commercial Rentals:");
		System.out.println("No  Rental Code    Customer ID    Customer Type   Number of Months   Car Model        Model Year   Rental Price");
		for(int i=0; i<5; i++) {
			Commercial comm = commercials.get(i);
			System.out.print(count +  "     " + comm.getRentalCode() + "      "+ comm.getId() + "        " +  comm.getCustomerType());
			if (comm.getCustomerType().length() > 6) {
				System.out.print("             " + comm.getNumberOfMonths() + "            " + comm.getCarModel() + "           " +  comm.getModelYear() + "         " + comm.calculateRentalPrice());
			}else if (comm.getCustomerType().length() == 6){
				System.out.print("               " + comm.getNumberOfMonths() + "           " + comm.getCarModel() + "         " + comm.getModelYear() + "          " + comm.calculateRentalPrice());
			}else {
				System.out.print("                 " + comm.getNumberOfMonths() + "          " + comm.getCarModel() + "  " + comm.getModelYear() + "         " + comm.calculateRentalPrice());
			}
			System.out.println();
			count++;
		}
	}
}
