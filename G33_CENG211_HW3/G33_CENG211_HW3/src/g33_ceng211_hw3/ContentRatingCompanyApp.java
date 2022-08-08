package g33_ceng211_hw3;

import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ContentRatingCompanyApp {
	
	static List<List<String>> movies = new ArrayList();
	static List<List<String>> games = new ArrayList();
	static List<String> movieEvaluationList = new ArrayList();
	static List<String> gameEvaluationList = new ArrayList();
	

	public static void main(String[] args) {
		readCsv("./csv/contents.csv");  //
		
		Stack<List<String>> movieStack = new Stack<List<String>>();
		Stack<List<String>> gameStack = new Stack<List<String>>();
		
		Queue<MovieCritic> mCriticQueue = new LinkedList<>();
		MovieCritic m1 =  new MovieCritic(1,0.1);
		MovieCritic m2 =  new MovieCritic(2,-0.2);
		MovieCritic m3 =  new MovieCritic(3,0.3);
		
		mCriticQueue.add(m1);
		mCriticQueue.add(m2);
		mCriticQueue.add(m3);
		
		Queue<GameCritic> gCriticQueue =  new LinkedList<>();
		GameCritic g1 = new GameCritic(1,5);
		GameCritic g2 = new GameCritic(2,9);
		GameCritic g3 = new GameCritic(3,-3);
		GameCritic g4 = new GameCritic(4,2);
		GameCritic g5 = new GameCritic(5,-7);
		
		gCriticQueue.add(g1);
		gCriticQueue.add(g2);
		gCriticQueue.add(g3);
		gCriticQueue.add(g4);
		gCriticQueue.add(g5);
		
		List<MovieCritic> mBusyCritics = new ArrayList<MovieCritic>();
		List<GameCritic> gBusyCritics = new ArrayList<GameCritic>();
		for(int day = 1; day <= 5; day++) {
			System.out.println("\nDay " + (day) + "\n");
			movieCriticsEvaluation(mCriticQueue, movieStack, mBusyCritics, day);
			gameCriticsEvaluation(gCriticQueue,gameStack,gBusyCritics,day);
		}
		
		System.out.println("\nRatings: ");
		for(int i = 0; i < movieEvaluationList.size(); i++) {
			System.out.println(movieEvaluationList.get(i));
		}
		
		System.out.println();
		for(int i = 0; i < gameEvaluationList.size(); i++) {
			System.out.println(gameEvaluationList.get(i));
		}
		
	}

	
	private static void gameCriticsEvaluation(Queue<GameCritic> gCriticQueue,Stack<List<String>> gameStack,List<GameCritic> gBusyCritics,int day) {
		
		while(true) {
			if(games.isEmpty() || Integer.parseInt(games.get(0).get(0)) > (day)) {
				break;
			}
			gameStack.push(games.get(0));
			games.remove(0);
		}
		
		for(int hourOfDay = 0; hourOfDay < 8; hourOfDay++) {
			organizeQueue(gCriticQueue,gBusyCritics);
			for(int i = 0; i < gBusyCritics.size(); i++) {
				double rating = gBusyCritics.get(i).evaluate(new ArrayList<>(),gameEvaluationList);
			}
			
			int gameStackSize = gameStack.size();
			for(int i = 0; i < gameStackSize; i++) {
				if(gCriticQueue.isEmpty())
					break;
				gBusyCritics.add(gCriticQueue.peek());
				gCriticQueue.poll().evaluate(gameStack.pop(),gameEvaluationList);

			}	
		}
		
	}
	
	private static void organizeQueue(Queue<GameCritic> gCriticQueue,List<GameCritic> gBusyCritics) {
		for(int i = 0; i < gBusyCritics.size(); i++) {
			if(gBusyCritics.get(i).isAvailable()) {
				gCriticQueue.add(gBusyCritics.get(i));
			}
		}
		gBusyCritics.removeIf(n -> (n.isAvailable()));		
	}
	
	
	private static void movieCriticsEvaluation(Queue<MovieCritic> mCriticQueue, Stack<List<String>> movieStack, List<MovieCritic> mBusyCritics,int day) {
		for(int i = 0; i < mBusyCritics.size(); i++) {
			mCriticQueue.add(mBusyCritics.get(i));
		}
		
		mBusyCritics.clear();
		while(true) {
			if(movies.isEmpty() || Integer.parseInt(movies.get(0).get(0)) > (day)) {
				break;
			}
			movieStack.push(movies.get(0));
			movies.remove(0);
		}
		
		int movieStackSize = movieStack.size();
		for(int i = 0; i < movieStackSize; i++) {
			if(mCriticQueue.isEmpty())
				break;
			mBusyCritics.add(mCriticQueue.peek());
			String movieName = movieStack.peek().get(2);
			String movieYear = movieStack.peek().get(3);
			System.out.println(mCriticQueue.peek().getId() + ".movie critic evaluated " + movieStack.peek().get(2));
			double rating = mCriticQueue.poll().evaluate(movieStack.pop(),movieEvaluationList);
			movieEvaluationList.add(movieName + ", " + movieYear + ", " + rating );
		}
		
	}

	private static void readCsv(String path){
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				if(values[1].equals("0")) {
					movies.add(Arrays.asList(values));
				} else {
					games.add(Arrays.asList(values));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}