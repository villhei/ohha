/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;

/**
 * LevelOne class initializes the list of obstacles associated with the level
 */
public class LevelOne implements GameLevel {
	
	ArrayList<Obstacle> obstacles;
	ArrayList<Snake> snakes;
	
	/**
	 * Constructor for creating level one,
	 * initializes the list of obstacles associated
	 * with the level
	 */
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
	
	/** Inherited method from the interface, init snakes,
	 *   up to three
	 * @param amount 
	 */
	@Override
	public void initSnakes(int amount)
	{
		snakes = new ArrayList<Snake>();
		snakes.add(new Snake(400, 200, 1));

		if (amount > 1) {
			snakes.add(new Snake(400, 300, 2));
		}
		if (amount > 2) {
			snakes.add(new Snake(400, 400, 3));
		}
		
	}
	/**
	 *  Returns a list of obstacles
	 * @return list of obstacles
	 */

	@Override
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	/**
	 *  Return the snakes in the level
	 * @return list of snakes
	 */
	
	@Override
	public ArrayList<Snake> getSnakes() {
		return snakes;
	}
	
}