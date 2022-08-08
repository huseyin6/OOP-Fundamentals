package g33_ceng211_hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GameCritic implements ICritic {
	
	private int currentGameMode = 0;
	private Map<String,Integer> currentGame;
	private List<String> currentGameInfo;
	private double opinionBias;
	private int id;

	public GameCritic(int id,double bias) {
		this.id = id;
		this.opinionBias = bias;
		currentGame = new HashMap<String,Integer>();
		currentGameInfo = new ArrayList<String>();

	}
	public boolean isAvailable() {
		return currentGame.isEmpty() ;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@Override
	public double evaluate(List<String> item,List<String> item2) {
		if(currentGame.isEmpty()) {
			currentGameInfo.add(item.get(0));
			currentGameInfo.add(item.get(1));
			currentGameInfo.add(item.get(2));
			currentGameInfo.add(item.get(3));
			currentGameInfo.add(item.get(4));

			
			currentGameMode = Integer.parseInt(currentGameInfo.get(1));
			int timeToWork = 0;
			switch(currentGameMode) {
			case 1:
				//timeToWork = 4;
			case 2:
				timeToWork = Integer.parseInt(currentGameInfo.get(3));
				break;
			case 3:
				timeToWork = Integer.parseInt(currentGameInfo.get(3)) * 3;
				break;
			}
			
			currentGame.put(item.get(2), timeToWork);
			System.out.println(id + ".game critic works on " + currentGameInfo.get(2));
			return -1;
		} else {
			int timeLeft = currentGame.get(currentGameInfo.get(2)) - 1;
			if(timeLeft <= 0) {

				int duration = Integer.parseInt(currentGameInfo.get(3));
				int averageRating = Integer.parseInt(currentGameInfo.get(4));
				double rating = 0;
				switch(currentGameMode) {
				case 1:
					rating = averageRating + ((10 - duration) * 0.25) + (opinionBias);
					break;
				case 2:
					rating = averageRating + (duration * 0.25) + (opinionBias);
					break;
				case 3:
					rating = averageRating + ((duration - 3) * 3) + (opinionBias);
					break;
					
				}
				System.out.println(id + ".game critic Evaluated " + currentGameInfo.get(2) + " and rating: " + rating);
				item2.add(currentGameInfo.get(2) + ", " + rating);

				currentGame.clear();
				currentGameInfo.clear();
				
				
				return rating;
			} else {
				currentGame.put(currentGameInfo.get(2), timeLeft);
				//System.out.println(id + " working on " + currentGameInfo.get(2) + " TimeLeft:" + (timeLeft));
				return -1;	
			}		
		}	
	}

}
