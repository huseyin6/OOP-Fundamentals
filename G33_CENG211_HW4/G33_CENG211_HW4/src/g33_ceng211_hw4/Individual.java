package g33_ceng211_hw4;

public class Individual<T> implements ICustomer {
	
	private T id;
	private int numberOfDays;
	private String carModel;
	private int modelYear;
	private double basePrice;
	private long rentalCode;
	
	public Individual(T id, int numberOfDays, String carModel, int modelYear, double basePrice) {
		super();
		this.id = id;
		this.numberOfDays = numberOfDays;
		this.carModel = carModel;
		this.modelYear = modelYear;
		this.basePrice = basePrice;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
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
		String checkIfString = "";
		if (id.getClass() == checkIfString.getClass()) {
			return true;
		}
		return false;
	}

	@Override
	public double calculateRentalPrice() {
		double dailyPrice = getBasePrice() * getModelYearRatio();
		double overallPrice = getNumberOfDays() * dailyPrice;
		if (isMember()) {
			double discount = 0.10;
			double rentalPrice = overallPrice - (overallPrice * discount);
			return rentalPrice;
		}
		return overallPrice;
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

}
