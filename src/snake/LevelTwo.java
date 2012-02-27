/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;

/**
 * LevelTwo class initializes the list of obstacles associated with the level
 */
public class LevelTwo implements GameLevel {

	ArrayList<Obstacle> obstacles;
	ArrayList<Snake> snakes;

	public LevelTwo() {

		Obstacle ylareuna = new Obstacle(0, 0, 800, 20);
		Obstacle alareuna = new Obstacle(0, 580, 800, 20);


		Obstacle vasreuna = new Obstacle(0, 20, 20, 560);
		Obstacle oikreuna = new Obstacle(780, 20, 20, 560);

		Obstacle keski = new Obstacle(300, 200, 200, 20);
		Obstacle keskiala = new Obstacle(300, 400, 200, 20);

		obstacles = new ArrayList<Obstacle>();

		obstacles.add(oikreuna);
		obstacles.add(vasreuna);
		obstacles.add(ylareuna);
		obstacles.add(alareuna);
		obstacles.add(keski);
		obstacles.add(keskiala);

	}

	/**
	 * Inherited method from the interface, init snakes, up to three
	 *
	 * @param amount
	 */
	@Override
	public void initSnakes(int amount) {
		snakes = new ArrayList<Snake>();
		snakes.add(new Snake(400, 40, 1));

		if (amount > 1) {
			snakes.add(new Snake(400, 360, 2));
		}
		if (amount > 2) {
			snakes.add(new Snake(400, 560, 3));
		}

	}

	/**
	 * Returns a list of obstacles
	 *
	 * @return list of obstacles
	 */
	@Override
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	/**
	 * Return the snakes in the level
	 *
	 * @return list of snakes
	 */
	@Override
	public ArrayList<Snake> getSnakes() {
		return snakes;
	}
}