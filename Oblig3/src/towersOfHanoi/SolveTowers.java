package towersOfHanoi;

import java.sql.Time;

public class SolveTowers {

	public static void main(String[] args) {
		
		long timerStart = System.currentTimeMillis();
		TowersOfHanoi towers = new TowersOfHanoi(20);
		towers.solve();
		long timerEnd = System.currentTimeMillis();
		System.out.println("It took " + (timerEnd - timerStart) + " milliseconds");
	}
}