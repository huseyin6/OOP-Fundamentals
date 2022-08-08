package g33_ceng211_hw3;

import java.util.List;

public class MovieCritic implements ICritic {
	
	private double opinionBias;
	private int id;

	public MovieCritic(int id,double bias) {
		this.id = id;
		opinionBias = bias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public double evaluate(List<String> item, List<String> item2) {
		double avgRating = Double.parseDouble(item.get(5));
		int duration = Integer.parseInt(item.get(4));
		int year = Integer.parseInt(item.get(3));
		return avgRating + ((duration - 150) * 0.01) - ((2021 - year) * 0.01) + (opinionBias);
	}

}
