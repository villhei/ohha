/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;

/**
 *
 * @author villheik
 */
public class LevelOne implements GameLevel {
	
	ArrayList<Obstacle> obstacles;
	
	public LevelOne()
	{
		Obstacle ylareuna = new Obstacle(0, 0, 800, 20);
		Obstacle alareuna = new Obstacle(0, 580, 800, 20);
		
		
		Obstacle vas_yla_reuna = new Obstacle(0, 20, 20, 240);
		Obstacle vas_ala_reuna = new Obstacle(0, 360, 20, 240);
		Obstacle oik_yla_reuna = new Obstacle(780, 20, 20, 240);
		Obstacle oik_ala_reuna = new Obstacle(780, 360, 20, 240);
		
		obstacles = new ArrayList<Obstacle>();
		
		obstacles.add(oik_yla_reuna);
		obstacles.add(oik_ala_reuna);
		obstacles.add(vas_yla_reuna);
		obstacles.add(vas_ala_reuna);
		obstacles.add(ylareuna);
		obstacles.add(alareuna);
		
		
		
	}

	@Override
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	
}
