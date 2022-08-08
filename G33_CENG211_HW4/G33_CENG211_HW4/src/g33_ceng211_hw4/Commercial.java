package g33_ceng211_hw4;

public class Commercial implements ICustomer {
	
	private String id;
	private int numberOfMonths;
	private String carModel;
	private int modelYear;
	private double basePrice;
	private long rentalCode;
	
	public Commercial(String id, int numberOfMonths, String carModel, int modelYear, double basePrice) {
		super();
		this.id = id;
		this.numberOfMonths = numberOfMonths;
		this.carModel = carModel;
		this.modelYear = modelYear;
		this.basePrice = basePrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumberOfMonths() {
		return numberOfMonths;
	}

	public void setNumberOfMonths(int numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	public long getRentalCode() {
		return rentalCode;
	}

	public void setRentalCode(long rentalCode) {
		this.rentalCode = rentalCode;
	}

	@Override
	public boolean addMember(ICustomer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMember() {
		return true;
	}

	@Override
	public double calculateRentalPrice() {
		double dailyPrice = getBasePrice() * getModelYearRatio();
		double monthlyPrice = getNumberOfMonths() * 30 * dailyPrice;
		String customerType = getCustomerType();
		if (customerType.equals("Silver")) {
			double discount = 0.20;
			double rentalPrice = monthlyPrice - (monthlyPrice * discount);
			return rentalPrice;
		}else if(customerType.equals("Gold")) {
			double discount = 0.25;
			double rentalPrice = monthlyPrice - (monthlyPrice * discount);
			return rentalPrice;
		}else {
			double discount = 0.30;
			double rentalPrice = monthlyPrice - (monthlyPrice * discount);
			return rentalPrice;
		}
	}
	
	private double getModelYearRatio() {
		int modelYear = getModelYear();
		if (modelYear >= 2022) {
			return 1;
		}else if (modelYear >= 2020) {
			return 0.95;
		}else {
			return 0.90;
		}
	}
	
	public String getCustomerType() {
		String type = id.substring(0, 1);
		if (type.equals("S")) {
			return "Silver";
		}else if(type.equals("G")) {
			return "Gold";
		}else {
			return "Platinum";
		}
	}

}
