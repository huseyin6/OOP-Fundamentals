package g33_ceng211_hw2;

public class FinancialStatus extends Applicant {
	
	private int income;
	private int savings;
	
	public FinancialStatus(int applicantID, int income, int savings) {
		super(applicantID);
		this.income = income;
		this.savings = savings;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getSavings() {
		return savings;
	}

	public void setSavings(int savings) {
		this.savings = savings;
	}

}
